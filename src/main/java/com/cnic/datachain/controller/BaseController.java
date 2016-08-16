package com.cnic.datachain.controller;

import com.cnic.datachain.entity.vo.PageFacade;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pangbo on 2015/5/18.
 * good day commander!
 */
public class BaseController {

    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    private static final int DEFAULT_PAGESIZE = 10;

    protected PageFacade preparedPageParam(String aoData) {

        String jsonData = aoData;
        JSONArray jsonarray = JSONArray.fromObject(jsonData);
        int iDisplayStart = 0;
        int iDisplayLength = 1;
        String sEcho = "";

        for (int i = 0; i < jsonarray.size(); i++) {

            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();
            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.get("value").toString()==null ? 0 : Integer.parseInt(obj.get("value").toString());
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.get("value").toString()==null ? DEFAULT_PAGESIZE: Integer.parseInt(obj.get("value").toString());
        }

        int displayStartPageIndex = (iDisplayStart / iDisplayLength)==0 ? 1 : iDisplayStart / iDisplayLength + 1;

        PageFacade page = new PageFacade();
        page.setsEcho(sEcho);
        page.setPageNo(displayStartPageIndex);
        page.setPageSize(iDisplayLength);
        return page;

    }

    /**
     * 从SystemContext过滤器中获取设置的page和size
     * @param request
     * @return
     */
    public PageFacade initPageRequest(HttpServletRequest request) {
        Object pageNo = request.getAttribute("page");
        Object pageSize = request.getAttribute("size");
        PageFacade pageFacade = new PageFacade();
        pageFacade.setPageNo(pageNo == null ? 1 : Integer.parseInt(pageNo.toString()));
        pageFacade.setPageSize(pageSize == null ? DEFAULT_PAGESIZE : Integer.parseInt(pageSize.toString()));
        return pageFacade;
    }
}
