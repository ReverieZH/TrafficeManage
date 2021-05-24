package com.reverie.service;


import com.reverie.domain.Syslog;

import java.util.List;

public interface SyslogService {

    /**
     * 将日志信息存储到数据库中
     * @param syslog
     */
    public void save(Syslog syslog);

    /**
     * 查询所有日志信息
     * @return
     */
    public List<Syslog> findAll(int page, int size);

    /**
     * 根据工号查询日志信息
     * @param jobNumber
     * @param page
     * @param size
     * @return
     */
    public List<Syslog> findByJobNumber(String jobNumber, Integer page, Integer size);
}
