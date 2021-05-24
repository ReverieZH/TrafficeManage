package com.reverie.service.impl;

import com.reverie.domain.Platenumberapply;
import com.reverie.mapper.PlatenumberapplyMapper;
import com.reverie.service.PlateNumberApplyService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("plateNumberApplyService")
public class PlateNumberApplyServiceImpl implements PlateNumberApplyService {
    @Autowired
    private PlatenumberapplyMapper platenumberapplyMapper;

    @Override
    public Platenumberapply selectByKey(String applyNumber) {
        return platenumberapplyMapper.selectByPrimaryKey(applyNumber);
    }

    @Override
    public List<Platenumberapply> selectAll() {
        return platenumberapplyMapper.selectAll();
    }

    @Override
    public List<Platenumberapply> selectCondiion(String status) {
        return platenumberapplyMapper.selectList(status);
    }

    @Override
    public List<Platenumberapply> selectByUsername(String username) {
        Platenumberapply platenumberapply=new Platenumberapply();
        platenumberapply.setUsername(username);
        return  platenumberapplyMapper.select(platenumberapply);
    }

    @Override
    public int delete(String applyNumber) {
        return platenumberapplyMapper.deleteByPrimaryKey(applyNumber);
    }

    @Override
    public int deleteList(List<String> applyNumbers) {
        return 0;
    }

    @Override
    public String save(Platenumberapply platenumberapply) {
        String maxNumber = platenumberapplyMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String applyNumber="";
        int total=0;
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            applyNumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            applyNumber=DateUtil.getCurrentDateStr()+"001";
        }
        platenumberapply.setApplyNumber(applyNumber);
        total=platenumberapplyMapper.insert(platenumberapply);
        if(total>0){
            return applyNumber;
        }else{
            return null;
        }
    }

    @Override
    public int update(Platenumberapply platenumberapply) {
        return platenumberapplyMapper.updateByPrimaryKeySelective(platenumberapply);
    }

    @Override
    public int changeStatus(String plateNumber, String status) {
        return 0;
    }

    @Override
    public int handle(String applyNumber) {
        Platenumberapply platenumberapply=new Platenumberapply();
        platenumberapply.setApplyNumber(applyNumber);
        platenumberapply.setStatus("1");
        return platenumberapplyMapper.updateByPrimaryKeySelective(platenumberapply);
    }
}
