package com.cnic.datachain.dao;

import com.cnic.datachain.entity.Action;

import java.util.List;
import java.util.Map;

/**
 * Created by xjzhu@cnic.cn on 2016/8/16.
 */
public interface ActionDao {

    public int insertAction(Action action);
    public int countAction(Action action);
    public List<Action> selectActionByPage(Map<String, Object> map);
    public List<Action> selectAllAction(Action action);
}
