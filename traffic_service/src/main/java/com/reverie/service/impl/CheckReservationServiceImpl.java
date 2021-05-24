package com.reverie.service.impl;

import com.reverie.domain.Checkreservation;
import com.reverie.mapper.CheckreservationMapper;
import com.reverie.service.CheckReservationService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CheckReservationServiceImpl implements CheckReservationService {
    @Autowired
    private CheckreservationMapper checkreservationMapper;

    @Override
    public String save(Checkreservation checkreservation) {
        String maxNumber = checkreservationMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String reserveNumber="";
        int total=0;
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            reserveNumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            reserveNumber=DateUtil.getCurrentDateStr()+"001";
        }
        checkreservation.setReserveNumber(reserveNumber);
        int insert = checkreservationMapper.insert(checkreservation);
        if(insert>0){
            return reserveNumber;
        }else {
            return null;
        }
    }

    @Override
    public List<Checkreservation> selectByUsername(String username) {
        Checkreservation checkreservation=new Checkreservation();
        checkreservation.setUsername(username);
        return checkreservationMapper.select(checkreservation);
    }

    @Override
    public List<Checkreservation> selectAll() {
        return checkreservationMapper.selectAll();
    }

    @Override
    public List<Checkreservation> selectApplying() {
        Checkreservation checkreservation=new Checkreservation();
        checkreservation.setStatus("2");
        return checkreservationMapper.select(checkreservation);
    }

    @Override
    public Checkreservation selecyById(String reserveNumber) {
        return checkreservationMapper.selectByPrimaryKey(reserveNumber);
    }

    @Override
    public int handle(String reserveNumber, String status) {
        Checkreservation checkreservation=new Checkreservation();
        checkreservation.setReserveNumber(reserveNumber);
        checkreservation.setStatus(status);
        return checkreservationMapper.updateByPrimaryKeySelective(checkreservation);
    }


}
