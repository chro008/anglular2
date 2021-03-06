package com.lbsky.angular_demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.lbsky.angular_demo.bean.ListData;
import com.lbsky.angular_demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/angular/demo")
public class ListController {

    //增删改查
    @Autowired
    ListService service;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public JSONObject get(@RequestParam int page) {
        return service.getWithTotal(page);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void add(@RequestBody ListData item) {
        System.out.println("request for add,item is:" + item.toString());
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        System.out.println("request for delete,id:" + id);
        service.delete(id);
    }


    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestParam String name, @RequestParam String city, @RequestParam int age) {
        System.out.println("request for update,id:" + id);
        System.out.println("name is:" + name + ",age is:" + age + ",city is:" + city);
    }

}
