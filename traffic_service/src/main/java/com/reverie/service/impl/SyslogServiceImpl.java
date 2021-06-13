package com.reverie.service.impl;

import com.github.pagehelper.PageHelper;
import com.reverie.domain.Syslog;
import com.reverie.mapper.SyslogMapper;
import com.reverie.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("syslogService")
@Transactional
public class SyslogServiceImpl implements SyslogService {

    @Autowired
    private SyslogMapper syslogMapper;

    @Override
    public void save(Syslog syslog) {
        syslogMapper.save(syslog);
    }

    @Override
    public List<Syslog> selectAll() {
        //参数pageNum是页码值，参数pageSize代表的是每页显示条数
        return syslogMapper.findAll();
    }

    @Override
    public List<Syslog> findByJobNumber(String jobNumber) {
        return syslogMapper.findByJobNumber(jobNumber);
    }
}
