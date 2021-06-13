package com.reverie.domain;

import com.reverie.utils.Date2StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 日志类
 */
public class Syslog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                 //日志id；主键自增
    private Date visitTime;         //访问时间
    @Transient
    private String visitTimeStr;    //访问时间字符串
    private String jobnumber;       //用户id；外键
    private String ip;              //访问者ip
    private String url;             //访问的资源路径
    private Long executionTime;    //访问耗时
    private String method;          //访问的方法名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVisitTimeStr() {
        if (this.visitTime != null){
            this.visitTimeStr = Date2StringUtils.date2String(visitTime);
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    @Override
    public String toString() {
        return "Syslog{" +
                "id=" + id +
                ", visitTime=" + visitTime +
                ", visitTimeStr='" + visitTimeStr + '\'' +
                ", jobnumber='" + jobnumber + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }
}
