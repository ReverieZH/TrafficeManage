package com.reverie.service.impl;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Vehiclelicense;
import com.reverie.mapper.VechilelicenseMapper;
import com.reverie.service.VehiclelicenseService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vehiclelicense")
public class VehiclelicenseServiceImpl implements VehiclelicenseService {
    @Autowired
    private VechilelicenseMapper vechilelicenseMapper;

    @Override
    public Vehiclelicense selectByKey(String vlnumber) {
        return vechilelicenseMapper.selectByPrimaryKey(vlnumber);
    }

    @Override
    public List<Vehiclelicense> selectAll() {
        return vechilelicenseMapper.selectAll();
    }

    @Override
    public List<Vehiclelicense> searchByName(String nameStr) {
        String name="%"+nameStr+"%";
        return vechilelicenseMapper.searchByName(name);
    }

    @Override
    public int delete(String vlnumber) {
        return vechilelicenseMapper.deleteByPrimaryKey(vlnumber);
    }

    @Override
    public int deleteList(List<String> vehiclelicense) {
        return 0;
    }

    @Override
    public int save(Vehiclelicense vehiclelicense) {
        String maxNumber = vechilelicenseMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String vlnumber="";
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            vlnumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            vlnumber=DateUtil.getCurrentDateStr()+"001";
        }
        vehiclelicense.setVlnumber(vlnumber);
        return vechilelicenseMapper.insert(vehiclelicense);
    }

    @Override
    public int update(Vehiclelicense vehiclelicense) {
        return vechilelicenseMapper.updateByPrimaryKeySelective(vehiclelicense);
    }

    @Override
    public int changeStatus(String vlnumber, String status) {
        Vehiclelicense vehiclelicense=new Vehiclelicense();
        vehiclelicense.setVlnumber(vlnumber);
        vehiclelicense.setStatus(status);
        return vechilelicenseMapper.updateByPrimaryKeySelective(vehiclelicense);
    }
}
