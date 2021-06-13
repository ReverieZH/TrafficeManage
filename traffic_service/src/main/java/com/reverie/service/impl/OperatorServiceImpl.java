package com.reverie.service.impl;

import com.github.pagehelper.PageHelper;
import com.reverie.domain.Operator;
import com.reverie.mapper.OperatorMapper;
import com.reverie.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("operatorService")
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorMapper operatorMapper;
    @Override
    public Operator login(String jobNumber,String password) {
        Operator condition=new Operator();
        condition.setJobnumber(jobNumber);
        condition.setPassword(password);
        return operatorMapper.selectOne(condition);
    }

    @Override
    public Operator selectByKey(String jobnumber) {
        return operatorMapper.selectByPrimaryKey(jobnumber);
    }


    @Override
    public List<Operator> selectAll(int page,int size) {
//        PageHelper.startPage(page,size);
        return operatorMapper.selectAll();
    }

    @Override
    public int delete(String jobnumber) {
        return operatorMapper.deleteByPrimaryKey(jobnumber);
    }

    @Override
    public int deleteList(List<String> jobnumbers) {
        return 0;
    }

    @Override
    public int save(Operator operator) {
        return operatorMapper.insert(operator);
    }

    @Override
    public int update(Operator operator) {
        return operatorMapper.updateByPrimaryKey(operator);
    }

    @Override
    public int changeStatus(String jobnumber, String status) {
        Operator operator=new Operator();
        operator.setJobnumber(jobnumber);
        operator.setVaild(status);
        return operatorMapper.updateByPrimaryKeySelective(operator);
    }
}
