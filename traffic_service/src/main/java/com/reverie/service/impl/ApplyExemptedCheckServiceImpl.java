package com.reverie.service.impl;

import com.reverie.domain.Applyexemptedcheck;
import com.reverie.mapper.ApplyExemptedCheckMapper;
import com.reverie.service.ApplyExemptedCheckService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplyExemptedCheckServiceImpl implements ApplyExemptedCheckService {

    @Autowired
    private ApplyExemptedCheckMapper applyExemptedCheckMapper;

    @Override
    public Applyexemptedcheck selectoneById(String acNumber) {
        return applyExemptedCheckMapper.selectByPrimaryKey(acNumber);
    }

    @Override
    public List<Applyexemptedcheck> selctAll() {
        return applyExemptedCheckMapper.selectAll();
    }

    @Override
    public List<Applyexemptedcheck> selectCondiion(String status) {
        Applyexemptedcheck applyexemptedcheck=new Applyexemptedcheck();
        applyexemptedcheck.setStatus(status);
        return applyExemptedCheckMapper.select(applyexemptedcheck);
    }

    @Override
    public List<Applyexemptedcheck> selectByUser(String username) {
        Applyexemptedcheck applyExemptedCheck=new Applyexemptedcheck();
        applyExemptedCheck.setUsername(username);
        return applyExemptedCheckMapper.select(applyExemptedCheck);
    }

    @Override
    public String save(Applyexemptedcheck applyexemptedcheck) {
        String maxNumber = applyExemptedCheckMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String acNumber="";
        int total=0;
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            acNumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            acNumber=DateUtil.getCurrentDateStr()+"001";
        }
        applyexemptedcheck.setAcNumber(acNumber);
        int save=applyExemptedCheckMapper.insert(applyexemptedcheck);
        if(save>0){
            return acNumber;
        }else{
            return null;
        }
    }

    @Override
    public int accpet(String acNumber,String status) {
        Applyexemptedcheck applyExemptedCheck=new Applyexemptedcheck();
        applyExemptedCheck.setAcNumber(acNumber);
        applyExemptedCheck.setStatus(status);
        return applyExemptedCheckMapper.updateByPrimaryKeySelective(applyExemptedCheck);
    }
}
