package com.cnic.datachain.controller;

import com.cnic.datachain.common.util.UUIDGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by xjzhu@cnic.cn on 2016/8/16.
 */

@Controller
@RequestMapping
public class IndexController extends BaseController{

    @RequestMapping(value = {"/index"})
    public String index(HttpServletRequest request) {
        //logger.info("visits page login.");
        return "index";
    }

    @RequestMapping(value = "/doAction", method = RequestMethod.GET)
    public String doAction(HttpServletRequest request) {
        logger.info(UUIDGenerator.getUUID() + ":" + new Date(System.currentTimeMillis()));
        //request.setAttribute("status", "successful");
        return "redirect:/index";
    }

}

