package com.cnic.datachain.dao;

import com.cnic.datachain.entity.AccessLog;

import java.util.List;
import java.util.Map;

/**
 * Created by Flora on 2016/8/23.
 */
public interface AccessLogDao {
    public int countAccessLog(AccessLog accessLog);
    public List<AccessLog> selectAccessLogByPage(Map<String, Object> map);
    public List<AccessLog> selectAllAccessLog(AccessLog accessLog);
}
