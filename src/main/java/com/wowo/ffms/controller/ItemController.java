package com.wowo.ffms.controller;

import com.wowo.ffms.entity.Account;
import com.wowo.ffms.entity.Item;
import com.wowo.ffms.service.ItemService;
import com.wowo.ffms.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;


    @RequestMapping("/getParent")
    @ResponseBody
    public List<Item> getParent(){
        return itemService.getParent();
    }


    @RequestMapping("/getChild")
    @ResponseBody
    public List<Item> getChild(@RequestParam("id")Integer id){
        return itemService.getChild(id);
    }

    @RequestMapping("/getAllItems")
    public String getAllItems(@RequestParam(value = "pn",defaultValue = "0")Integer pn,Model model){
        Page<Item> items = itemService.getAllItems(pn);
        model.addAttribute("pn",pn);
        int totalPages = items.getTotalPages();
        model.addAttribute("pnTotal",totalPages);
        model.addAttribute("items",items);
        String nums = PageUtil.getPageNum(totalPages, pn);
        model.addAttribute("clickNum",nums);
        return "/item/list";
    }

    @RequestMapping("/addItem")
    public String addItem(Model model){
        List<Item> parents = itemService.getParent();
        model.addAttribute("parents",parents);
        return "/item/add";
    }


    @RequestMapping("/checkItem")
    @ResponseBody
    public Map<String,Object> checkItem(Item item){
        boolean b = itemService.checkItem(item);
        Map<String, Object> map = new HashMap<>();
        if (b){
            map.put("code",100);
            map.put("msg","项目名可用");
        }else {
            map.put("code",200);
            map.put("msg","项目名不可用");
        }
        return map;
    }


    @RequestMapping("/saveItem")
    @ResponseBody
    public Map<String, Object> saveItem(Item item){

        boolean b = itemService.checkItem(item);
        Map<String, Object> map = new HashMap<>();
        if (b){
            map.put("code",100);
            itemService.saveItem(item);
        }else {
            map.put("code",200);
            map.put("msg","项目名不可用");
        }
        return map;
    }

    //跳转到编辑页面并获得当前项目的信息
    @RequestMapping("/toEditItem")
    public String toEditItem(@RequestParam("id")Integer id,Model model){
        Item item = itemService.getItemById(id);
        model.addAttribute("item",item);
        return "/item/edit";
    }

}
