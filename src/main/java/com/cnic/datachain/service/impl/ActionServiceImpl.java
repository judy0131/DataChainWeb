package com.cnic.datachain.service.impl;

import com.cnic.datachain.dao.ActionDao;
import com.cnic.datachain.entity.Action;
import com.cnic.datachain.entity.vo.PageFacade;
import com.cnic.datachain.entity.vo.TableElement;
import com.cnic.datachain.service.ActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xjzhu@cnic.cn on 2016/8/16.
 */
@Service
public class ActionServiceImpl extends BaseService implements ActionService{

    @Resource
    private ActionDao actionDao;

    @Override
    public int CreateAction(Action action){
        return 1;
    }

    @Override
    public TableElement<Action> findActionByPage(PageFacade pageRequest, Action action){

        List<Action> dataApplications = actionDao.selectActionByPage(super.injectBeanWithMap(pageRequest, action));
        int total = actionDao.countAction(action);
        TableElement<Action> tableElement = new TableElement<Action>(pageRequest.getsEcho(), total, total, dataApplications);
        return tableElement;
    }


}
