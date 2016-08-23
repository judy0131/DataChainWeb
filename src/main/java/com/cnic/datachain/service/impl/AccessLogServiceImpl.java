package com.cnic.datachain.service.impl;

import com.cnic.datachain.dao.AccessLogDao;
import com.cnic.datachain.entity.AccessLog;
import com.cnic.datachain.entity.vo.PageFacade;
import com.cnic.datachain.entity.vo.TableElement;
import com.cnic.datachain.service.AccessLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Flora on 2016/8/23.
 */
@Service
public class AccessLogServiceImpl extends BaseService implements AccessLogService{

    @Resource
    private AccessLogDao accessLogDao;

    @Override
    public TableElement<AccessLog> findAccessLogByPage(PageFacade pageRequest, AccessLog accessLog) {
        List<AccessLog> dataApplications = accessLogDao.selectAccessLogByPage(super.injectBeanWithMap(pageRequest, accessLog));
        int total = accessLogDao.countAccessLog(accessLog);
        TableElement<AccessLog> tableElement = new TableElement<AccessLog>(pageRequest.getsEcho(), total, total, dataApplications);
        return tableElement;
    }
}
