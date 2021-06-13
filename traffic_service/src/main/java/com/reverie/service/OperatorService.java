package com.reverie.service;

import com.reverie.domain.Operator;
import com.reverie.domain.User;

import java.util.List;

public interface OperatorService {
    public Operator login(String jobNumber,String password);

    public Operator selectByKey(String jobnumber);

    public List<Operator> selectAll(int page,int size);


    public int delete(String jobnumber);

    public int deleteList(List<String> jobnumbers);

    public int save(Operator operator);

    public int update(Operator operator);

    public int changeStatus(String jobnumber,String status);

}
