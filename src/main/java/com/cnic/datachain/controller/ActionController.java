package com.cnic.datachain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xjzhu@cnic.cn on 2016/8/16.
 */
@Controller
@RequestMapping(value = "/action")
public class ActionController {

    @RequestMapping(value = {"/index"})
    public String index(HttpServletRequest request) {
        return "index";
    }
}
