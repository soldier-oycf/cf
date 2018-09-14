package com.pinyougou.manage.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Date:2018/9/13*/

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/getUsername")
    public Map<String,Object> getUsername(){

        Map<String, Object> map = new HashMap<>();

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("username",name);

        return map;
    }
}

