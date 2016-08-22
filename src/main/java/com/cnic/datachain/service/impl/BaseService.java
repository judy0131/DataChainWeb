package com.cnic.datachain.service.impl;

import com.cnic.datachain.entity.vo.PageFacade;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xjzhu@cnic.cn on 2015/5/11.
 * good day commander!
 */
public class BaseService {

    public Map<String, Object> injectBeanWithMap(PageFacade pageRequest, Object bean) {
        int from = (pageRequest.getPageNo() - 1) * pageRequest.getPageSize();
        int size = pageRequest.getPageSize();
        HashMap<String , Object > map = new HashMap<String, Object>();
        map.put("start", from );
        map.put("offset", size ) ;
        map.put("bean", bean);
        return map;
    }

}
