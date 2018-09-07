package com.mystudy.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mystudy.springboot.service.IWhiterAccountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: GJB
 * @Date: 2018/9/6 18:27
 * @Description:
 */
@RestController
@RequestMapping("/whiteaccount")
public class WhiteAccountController {

    @Reference(version = "1.0.0") //相当于<dubbo:reference id="" interface=..  >
    private IWhiterAccountService whiterAccountService;

    @RequestMapping("/getwhiteaccountbyid/{id}")
    public Object getWhiteAccountById(@PathVariable("id")Integer id){
        return whiterAccountService.selectWhitelistAccountById(id);
    }

    @RequestMapping("/sayhi/{name}")
    public Object sayHi(@PathVariable("name")String name){
        return whiterAccountService.sayHi(name);
    }
}
