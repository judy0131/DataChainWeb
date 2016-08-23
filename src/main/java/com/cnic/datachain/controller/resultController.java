package com.cnic.datachain.controller;

import com.cnic.datachain.entity.AccessLog;
import com.cnic.datachain.entity.Action;
import com.cnic.datachain.entity.vo.PageFacade;
import com.cnic.datachain.entity.vo.TableElement;
import com.cnic.datachain.service.AccessLogService;
import com.cnic.datachain.service.ActionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xjzhu@cnic.cn on 2016/8/22.
 */
@Controller
@RequestMapping(value = "/result")
public class resultController extends BaseController {

    @Resource
    private ActionService actionService;

    @Resource
    private AccessLogService accessLogService;

    @RequestMapping
    public String index(HttpServletRequest request) {
        //logger.info("visits page login.");
        return "actionlist";
    }

    @RequestMapping(value = "/actionList")
    public @ResponseBody
    TableElement<Action> doSearch(String aoData, Action action) {
        PageFacade pageRequest = super.preparedPageParam(aoData);
        TableElement<Action> pageResponse = actionService.findActionByPage(pageRequest, action);

        return pageResponse;
    }

    @RequestMapping(value = "/accesslog")
    public String accessLog(HttpServletRequest request) {
        //logger.info("visits page login.");
        return "accesslog";
    }

    @RequestMapping(value = "/accessLogList")
    public @ResponseBody
    TableElement<AccessLog> accessLogList(String aoData, AccessLog accessLog) {
        PageFacade pageRequest = super.preparedPageParam(aoData);
        TableElement<AccessLog> pageResponse = accessLogService.findAccessLogByPage(pageRequest, accessLog);

        return pageResponse;
    }

}
