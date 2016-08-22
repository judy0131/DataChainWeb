package com.cnic.datachain.service;

import com.cnic.datachain.entity.Action;
import com.cnic.datachain.entity.vo.PageFacade;
import com.cnic.datachain.entity.vo.TableElement;

/**
 * Created by xjzhu@cnic.cn on 2016/8/16.
 */
public interface ActionService {

    public int CreateAction(Action action);
    public TableElement<Action> findActionByPage(PageFacade pageRequest, Action action);

}
