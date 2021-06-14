package com.reverie.service.impl;

import com.reverie.domain.Drivinglicence;
import com.reverie.mapper.DrivinglicenceMapper;
import com.reverie.service.DriveLicenceService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("driveLicenceService")
public class DriveLicenceServiceImpl implements DriveLicenceService {

    @Autowired
    private DrivinglicenceMapper drivinglicenceMapper;

    @Override
    public Drivinglicence selectByKey(String dlnumber) {
        return drivinglicenceMapper.selectByPrimaryKey(dlnumber);
    }

    @Override
    public List<Drivinglicence> selectAll() {
        return drivinglicenceMapper.selectAll();
    }

    @Override
    public List<Drivinglicence> searchByName(String nameStr) {
        String name="%"+nameStr+"%";
        return drivinglicenceMapper.searchByName(name);
    }

    @Override
    public int delete(String dlnumber) {
        return drivinglicenceMapper.deleteByPrimaryKey(dlnumber);
    }

    @Override
    public int deleteList(List<String> drivinglicence) {
        return 0;
    }

    @Override
    public int save(Drivinglicence drivinglicence) {
        String maxNumber = drivinglicenceMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String dlnumber="";
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            dlnumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            dlnumber=DateUtil.getCurrentDateStr()+"001";
        }
        drivinglicence.setDlnumber(dlnumber);
//        System.out.println("service-------------------:\n"+drivinglicence);
        return drivinglicenceMapper.insert(drivinglicence);
    }

    @Override
    public int update(Drivinglicence drivinglicence) {
        return drivinglicenceMapper.updateByPrimaryKeySelective(drivinglicence);
    }

    @Override
    public int changeStatus(String dlnumber, String status) {
        Drivinglicence drivinglicence=new Drivinglicence();
        drivinglicence.setDlnumber(dlnumber);
        drivinglicence.setStatus(status);
        return drivinglicenceMapper.updateByPrimaryKeySelective(drivinglicence);
    }
}
