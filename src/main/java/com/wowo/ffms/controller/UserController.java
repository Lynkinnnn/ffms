package com.wowo.ffms.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.wowo.ffms.entity.Account;
import com.wowo.ffms.entity.User;
import com.wowo.ffms.repository.UserRepository;
import com.wowo.ffms.service.UserService;
import com.wowo.ffms.utils.CodeUtil;
import com.wowo.ffms.utils.PageUtil;
import com.wowo.ffms.utils.SmsTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户端Controller
 */

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Integer id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @ResponseBody
    @RequestMapping("/checkUser")
    public Map checkUser(@RequestParam("name")String name){
        Map<String, Object> map = new HashMap<>();
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!name.matches(regx)){
            map.put("code",200);
            map.put("msg","用户名必须是6-16位数字和字母的组合或者2-5位中文");
            return map;
        }
        boolean b = userService.checkUser(name);
        if (b){
            map.put("code",100);
            map.put("msg","用户名可用");
            return map;
        }else {
            map.put("code",200);
            map.put("msg","用户名已存在不可用");
            return map;
        }
    }

    @RequestMapping("/addUser")
    public String addUser(){
        return "/user/add";
    }


    //新增用户
    @SuppressWarnings("all")
    @ResponseBody
    @RequestMapping("/user")
    public Map insertUser(User user,@RequestParam("conPwd")String conPwd){
        Map<String, Object> map = new HashMap<>();
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        String name = user.getName();
        String pwd = user.getPwd();
        if(!name.matches(regx)){
            map.put("code",200);
            map.put("msg","用户名必须是6-16位数字和字母的组合或者2-5位中文");
            return map;
        }
        if (!conPwd.equals(pwd)){
            map.put("code",300);
            map.put("msg","密码两次填写不符");
            return map;
        }
        boolean b = userService.checkUser(name);
        if (b){
            map.put("code",100);
            String encode = passwordEncoder.encode(user.getPwd());
            user.setPwd(encode);
            User save = userRepository.save(user);
            return map;
        }else {
            map.put("code",200);
            map.put("msg","用户名已存在不可用");
            return map;
        }
    }


    //登录页跳转
    @RequestMapping("/login.html")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session){
        boolean flag = userService.canLogin(user);
        if (user.getPwd() == null||user.getName() == null){
            model.addAttribute("msg","用户名或密码不能为空");
            return "/login";
        }
        else if (flag){
            session.setAttribute("loginUser",user.getName());
            model.addAttribute("name",user.getName());
            return "/index";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "/login";
        }
    }


    //得到所有用户数据并跳转到用户表页面
    @RequestMapping("/getAllUser")
    public String selectAllUser(@RequestParam(value = "pn",defaultValue = "0")Integer pn,@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,Model model){
        Page<User> users = userService.selectAllUser(pn,pageSize);
        model.addAttribute("pn",pn);
        int totalPages = users.getTotalPages();
        model.addAttribute("pnTotal",totalPages);
        model.addAttribute("users",users);
        String nums = PageUtil.getPageNum(totalPages, pn);
        model.addAttribute("clickNum",nums);
        return "/user/list";
    }


    //只获得所有用户的数据并返回json
    @RequestMapping("/getAllUserJson")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAll();
    }


    //短信验证
    @RequestMapping("/sendMessage")
    @ResponseBody
    public Map<String,Object> smsXxs(@RequestParam("phone")String phone, HttpServletRequest request,HttpSession session) throws ClientException {
        Map<String,Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        String code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\""+code+"\"}";
        // 短信模板id
        String TemplateCode = "SMS_174992408";
        SendSmsResponse response = SmsTool.sendSms(phone,TemplateParam,TemplateCode);
        map.put("verifyCode",code);
        map.put("phone",phone);
        session.setAttribute("heiheihei",code);
        session.setAttribute("phone",phone);
        session.setAttribute("createTime", System.currentTimeMillis());
        request.getSession().setAttribute("CodePhone",map);
        if( response.getCode().equals("OK")) {
            map.put("isOk","OK");
        }
        return map;
    }

    //短信验证登录
    @RequestMapping("/messageLogin")
    public String messageLogin(@RequestParam("code")String code,HttpServletRequest request,HttpSession session,Model model){
        String checkCode = request.getSession().getAttribute("heiheihei").toString().trim();
        String phone = request.getSession().getAttribute("phone").toString().trim();
        User user = userService.getUserByPhone(phone);
        if (code.equals(checkCode)){
            if(user != null){
                session.setAttribute("loginUser",user.getName());
                model.addAttribute("name",user.getName());
                return "/index";
            }else {
                model.addAttribute("msg","手机号码错误");
                return "/login";
            }
        }else {
            model.addAttribute("msg","验证码错误");
            return "/login";
        }
    }


    //用户详情：获得当前用户数据并跳转到详情页面
    @RequestMapping("/getUserById")
    public String toDetail(@RequestParam("id")Integer id,Model model){
        User user = userRepository.findUserById(id);
        model.addAttribute("user",user);
        return "user/detail";
    }



    //编辑用户：获取当前用户的信息并跳转到编辑页面
    @RequestMapping("/toEditUserById")
    public String toEditUserById(@RequestParam("id")Integer id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "/user/edit";
    }

    //批量删除
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public String deleteUserById(@RequestParam("ids[]")Integer[] ids){
        userService.deleteUserById(ids);
        return "删除成功";
    }


}
