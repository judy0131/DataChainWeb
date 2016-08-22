package com.cnic.datachain.controller;

import com.cnic.datachain.entity.Action;
import com.cnic.datachain.entity.vo.PageFacade;
import com.cnic.datachain.entity.vo.TableElement;
import com.cnic.datachain.service.ActionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by xjzhu@cnic.cn on 2016/8/22.
 */
@Controller
@RequestMapping(value = "/result")
public class resultController extends BaseController {

    @Resource
    private ActionService actionService;

    @RequestMapping(value = "/actionList")
    public @ResponseBody
    TableElement<Action> doSearch(String aoData, Action action) {
        PageFacade pageRequest = super.preparedPageParam(aoData);
        TableElement<Action> pageResponse = actionService.findActionByPage(pageRequest, action);

        return pageResponse;
    }


}
