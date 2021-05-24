package com.reverie.service.impl;

import com.reverie.domain.Losereplace;
import com.reverie.mapper.LosereplaceMapper;
import com.reverie.service.LoseReplaceService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoseReplaceServiceImpl implements LoseReplaceService {
    @Autowired
    private LosereplaceMapper losereplaceMapper;

    @Override
    public String save(Losereplace losereplace) {
        String maxNumber = losereplaceMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String loseReplaceNumber="";
        int total=0;
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            loseReplaceNumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            loseReplaceNumber=DateUtil.getCurrentDateStr()+"001";
        }
        losereplace.setLoseReplaceNumber(loseReplaceNumber);
        int insert = losereplaceMapper.insert(losereplace);
        if(insert>0){
            return loseReplaceNumber;
        }else{
            return null;
        }
    }

    @Override
    public List<Losereplace> selectAll() {
        return losereplaceMapper.selectAll();
    }

    @Override
    public List<Losereplace> selectApplying() {
        Losereplace losereplace=new Losereplace();
        losereplace.setStatus("2");
        return losereplaceMapper.select(losereplace);
    }

    @Override
    public Losereplace selectById(String loseReplaceNumber) {
        return losereplaceMapper.selectByPrimaryKey(loseReplaceNumber);
    }

    @Override
    public int handle(String loseReplaceNumber, String status) {
        Losereplace losereplace=new Losereplace();
        losereplace.setLoseReplaceNumber(loseReplaceNumber);
        losereplace.setStatus(status);
        return losereplaceMapper.updateByPrimaryKeySelective(losereplace);
    }
}
