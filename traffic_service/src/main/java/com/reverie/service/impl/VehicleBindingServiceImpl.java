package com.reverie.service.impl;

import com.reverie.domain.Car;
import com.reverie.domain.Vehiclebinding;
import com.reverie.mapper.VehiclebindingMapper;
import com.reverie.service.VehicleBindingService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleBindingServiceImpl implements VehicleBindingService {

    @Autowired
    private VehiclebindingMapper vehiclebindingMapper;

    @Override
    public int bind(String username, String plateNumber) throws Exception {
        String maxNumber = vehiclebindingMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String vbNumber="";
        int total=0;
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            vbNumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            vbNumber=DateUtil.getCurrentDateStr()+"001";
        }
        Vehiclebinding vehiclebinding=new Vehiclebinding();
        vehiclebinding.setVbNumber(vbNumber);
        vehiclebinding.setUsername(username);
        vehiclebinding.setPlateNumber(plateNumber);
        vehiclebinding.setStatus("2");
        vehiclebinding.setBindingate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss", DateUtil.getCurrentTime()));
        return vehiclebindingMapper.insert(vehiclebinding);
    }

    @Override
    public List<Car> selectCarByUser(String username) {
        return vehiclebindingMapper.selectCarByUser(username);
    }
}
