package com.cnic.datachain.service;

import com.cnic.datachain.entity.AccessLog;
import com.cnic.datachain.entity.vo.PageFacade;
import com.cnic.datachain.entity.vo.TableElement;

/**
 * Created by Flora on 2016/8/23.
 */
public interface AccessLogService {
    public TableElement<AccessLog> findAccessLogByPage(PageFacade pageRequest, AccessLog accessLog);
}
