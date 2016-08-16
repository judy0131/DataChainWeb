package com.cnic.datachain.entity.vo;

import com.cnic.datachain.common.util.PropertyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pangbo on 2015/5/18.
 * good day commander!
 */
public class PageFacade<T> {

    private List<T> content = new ArrayList<T>();
    private int pageNo;
    private int pageSize;
    private int totalRecord;
    private int totalPage;

    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private int from;
    private int to;

    private String sEcho;

    private static final int DEFAULT_PAGESIZE = PropertyUtil.getInstance().getIntegerPropertyValue("page.pagesize");

    public void setPageRequest(int pageNo, int pageSize, int totalRecord) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = (totalRecord % pageSize == 0) ? totalRecord / pageSize : totalRecord / pageSize + 1;
        this.hasNextPage = (pageNo < this.totalPage) ? true : false;
        this.hasPreviousPage = (pageNo > 1) ?  true : false;
        this.from = (pageNo - 1) * pageSize + 1;
        this.to = pageNo * pageSize;
    }

    public PageFacade() {

    }


    public PageFacade(int pageNo, int pageSize, int totalRecord, List<T> content) {
        this.setPageRequest(pageNo, pageSize, totalRecord);
        this.setContent(content);
    }

    public PageFacade(int totalRecord) {
        this.setPageRequest(1, DEFAULT_PAGESIZE, totalRecord);
    }

    public PageFacade(int pageNo, int totalRecord) {
        this.setPageRequest(pageNo, DEFAULT_PAGESIZE, totalRecord);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }
}
