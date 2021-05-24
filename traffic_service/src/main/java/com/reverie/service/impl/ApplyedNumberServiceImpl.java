package com.reverie.service.impl;

import com.reverie.domain.Applyednumber;
import com.reverie.mapper.ApplyedNumberMapper;
import com.reverie.service.ApplyedNumberService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("applyedNumberService")
public class ApplyedNumberServiceImpl implements ApplyedNumberService {

    @Autowired
    private ApplyedNumberMapper applyedNumberMapper;

    @Override
    public List<Applyednumber> selectPlateNumber(String username) {
        Applyednumber applyednumber=new Applyednumber();
        applyednumber.setUsername(username);
        return applyedNumberMapper.select(applyednumber);
    }

    @Override
    public int save(Applyednumber applyednumber) {
        String maxNumber = applyedNumberMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String applyNumber="";
        int total=0;
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            applyNumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            applyNumber=DateUtil.getCurrentDateStr()+"001";
        }
        applyednumber.setApplyednumberid(applyNumber);
        return applyedNumberMapper.insert(applyednumber);
    }


}
