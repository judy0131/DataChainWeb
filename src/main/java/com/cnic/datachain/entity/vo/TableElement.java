package com.cnic.datachain.entity.vo;

import java.util.List;


public class TableElement<T> {
    private String sEcho;
    private Integer iTotalRecords;
    private Integer iTotalDisplayRecords;
    private List<T> aaData;

    public TableElement() {
    }

    public TableElement(Integer iTotalRecords,
                        Integer iTotalDisplayRecords, List<T> aaData) {
        super();
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.aaData = aaData;
    }

    public TableElement(String sEcho, Integer iTotalRecords, Integer iTotalDisplayRecords, List<T> aaData) {
        this.sEcho = sEcho;
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.aaData = aaData;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public Integer getITotalRecords() {
        return iTotalRecords;
    }

    public void setITotalRecords(Integer iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Integer getITotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setITotalDisplayRecords(Integer iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }

}
