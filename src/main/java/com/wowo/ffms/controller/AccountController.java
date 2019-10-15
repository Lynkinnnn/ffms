package com.wowo.ffms.controller;


import com.wowo.ffms.entity.Account;
import com.wowo.ffms.entity.Item;
import com.wowo.ffms.repository.AccountRepository;
import com.wowo.ffms.service.AccountService;
import com.wowo.ffms.utils.PageInfo;
import com.wowo.ffms.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AccountController {


    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAll(){
        return accountRepository.findAll();
    }


    //新增账单
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    @ResponseBody
    public Account insertAccount(Account account){
        Account save = accountService.save(account);
        return save;
    }

    //编辑账单
    @RequestMapping("/editAccount")
    @ResponseBody
    public String editAccount(Account account){
        account.setId(account.getId());
        accountService.edit(account);
        return "修改成功";
    }


    @RequestMapping("/all/{pn}")
    @ResponseBody
    public Page<Account> getAll(@PathVariable("pn")Integer pn, Model model){
        Page<Account> all = accountService.findAll(pn);
        model.addAttribute("page",all);
        return all;
    }


    //跳转到账单list页面
    @RequestMapping("/getAllAccounts")
    public String getAllAccounts(@RequestParam(value = "pn",defaultValue = "0")Integer pn,@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize ,Model model){

        //HashMap<String, Object> map = new HashMap<>();
//        PageHelper.startPage(pn,5);
//        List<Account> accounts = accountService.getAllAccounts();
//        PageInfo<Account> page = new PageInfo<>(accounts);
        //map.put("page",page);
        Page<Account> accounts = accountService.getAllAccounts(pn,pageSize);
        model.addAttribute("accounts",accounts);
        model.addAttribute("pn",pn);
        int totalPages = accounts.getTotalPages();
        //int nums = (int)accounts.getTotalElements();
        model.addAttribute("pnTotal",totalPages);
        model.addAttribute("pageSize",pageSize);
        //PageInfo page = new PageInfo(getAll(),5);
//        int[] nums = page.getNavigatepageNums();
//        model.addAttribute("clickNum",nums);
        String nums = PageUtil.getPageNum(totalPages, pn);
        model.addAttribute("clickNum",nums);
        return "account/list";
    }

    //跳转到账单查询页面（所有数据）
    @RequestMapping("/findAllAccounts")
    public String findAllAccounts(@RequestParam(value = "pn",defaultValue = "0")Integer pn, @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, Model model){

        //HashMap<String, Object> map = new HashMap<>();
//        PageHelper.startPage(pn,5);
//        List<Account> accounts = accountService.getAllAccounts();
//        PageInfo<Account> page = new PageInfo<>(accounts);
        //map.put("page",page);
        Page<Account> accounts = accountService.getAllAccounts(pn,pageSize);
        model.addAttribute("accounts",accounts);
        model.addAttribute("pn",pn);
        int totalPages = accounts.getTotalPages();
        model.addAttribute("pnTotal",totalPages);
        String nums = PageUtil.getPageNum(totalPages, pn);
        model.addAttribute("clickNum",nums);
        return "account/find";
    }


    //跳转到账单查询页面
    @RequestMapping("/find")
    public String getFind(@RequestParam(value = "pn",defaultValue = "0")Integer pn,@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, Model model){
        Page<Account> accounts = accountService.getAllAccounts(pn,pageSize);
        model.addAttribute("accounts",accounts);
        model.addAttribute("pn",pn);
        int totalPages = accounts.getTotalPages();
        model.addAttribute("pnTotal",totalPages);
//        model.addAttribute("startDate","2016-02-01");
//        model.addAttribute("endDate","2019-01-01");
        model.addAttribute("is",0);
        String nums = PageUtil.getPageNum(totalPages, pn);
        model.addAttribute("clickNum",nums);
        return "account/find";
    }

    //查询页面按照时间段查询
    @RequestMapping("/findAccountByTime")
    //@ResponseBody
    public String findAccountByTime(@RequestParam(value = "pn",defaultValue = "0")Integer pn,@RequestParam("startDate")Date startDate1,@RequestParam("endDate")Date endDate1,Model model){
        Page<Account> accounts = accountService.findAccountByTime(pn,startDate1,endDate1);
        model.addAttribute("accounts",accounts);
        model.addAttribute("pn",pn);
        int totalPages = accounts.getTotalPages();
        model.addAttribute("pnTotal",totalPages);
        model.addAttribute("is",1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = sdf.format(startDate1);
        String endDate = sdf.format(endDate1);
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate",endDate);
        String str = "/findAccountByTime?pn="+pn+"&startDate="+startDate+"&endDate="+endDate;
        model.addAttribute("href",str);
        String nums = PageUtil.getPageNum(totalPages, pn);
        model.addAttribute("clickNum",nums);
        return "account/find";
    }


    //根据id查询账单数据
    @RequestMapping("/getAccountById")
    public String getAccountById(@RequestParam("id")Integer id,Model model){
        Account account = accountService.getAccountById(id);
        model.addAttribute("account",account);
        return "account/detail";
    }

    //编辑用户：获取当前用户的信息并跳转到编辑页面
    @RequestMapping("/toEditAccountById")
    public String toEditAccountById(@RequestParam("id")Integer id,Model model){
        Account account = accountService.getAccountById(id);
        model.addAttribute("account",account);
        return "account/edit";
    }




//    @RequestMapping("/findAccountByTime")
//    //@ResponseBody
//    public String findAccountByTime(@RequestParam(value = "pn",defaultValue = "0")Integer pn,@RequestParam("startDate")Date startDate,@RequestParam("endDate")Date endDate,Model model){
//        List<Account> accounts = accountService.findAccountByTime(startDate,endDate);
//        model.addAttribute("accounts",accounts);
//        return "/account/find";
//    }



    @RequestMapping("/bbtj03")
    public String report3(Model model){
        List<Item> items = accountService.getAllByItemType(1);
        model.addAttribute("items",items);
        return "report/bbtj_03";
    }

    @RequestMapping("/bbtj04")
    public String report4(Model model){
        List<Item> items = accountService.getAllByItemType(2);
        model.addAttribute("items",items);
        return "report/bbtj_04";
    }

    @RequestMapping("/bbtj05")
    public String report5(Model model){
        List<Item> items = accountService.getAllByItemType(1);
        model.addAttribute("items",items);
        return "report/bbtj_05";
    }


    @RequestMapping("/getByMonth")
    @ResponseBody
    public List<Map<String,Object>> findByMonth(@RequestParam("type")Integer type,@RequestParam("year")Integer year){
        return accountService.findByMonth(type,year);
    }

    @RequestMapping("/getByItemName")
    @ResponseBody
    public List<Map<String,Object>> findByItemName(@RequestParam("name")String name,@RequestParam("year")Integer year){
        return accountService.findByItemName(name,year);
    }

    @RequestMapping("/report")
    public String report(){
        return "report/bbtj";
    }

    @RequestMapping("/deleteAccountById")
    @ResponseBody
    public Map<String,Object> deleteAccountById(@RequestParam("ids[]")Integer[] ids){
        accountService.deleteAccountById(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("message","删除成功");
        return map;
    }


    //跳转到新增账单页面
    @RequestMapping("/toAddAccount")
    public String toAccount(){
        return "account/add";
    }

}
