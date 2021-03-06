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
    public List<Syslog> selectAll();

    /**
     * 根据工号查询日志信息
     * @param jobNumber
     * @return
     */
    public List<Syslog> findByJobNumber(String jobNumber);
}
