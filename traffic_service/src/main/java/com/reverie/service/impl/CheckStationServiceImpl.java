package com.reverie.service.impl;

import com.reverie.domain.Checkstation;
import com.reverie.mapper.CheckStationMapper;
import com.reverie.service.CheckStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckStationServiceImpl implements CheckStationService {
   @Autowired
   private CheckStationMapper checkStationMapper;
    @Override
    public List<Checkstation> selectAll() {
        return checkStationMapper.selectAll();
    }

    @Override
    public List<Checkstation> selectByProvince(String province) {
        Checkstation checkstation=new Checkstation();
        checkstation.setProvince(province);
        return checkStationMapper.select(checkstation);
    }

    @Override
    public List<Checkstation> selectByProvinceAndCity(String province, String city) {
        Checkstation checkstation=new Checkstation();
        checkstation.setProvince(province);
        checkstation.setCity(city);
        return  checkStationMapper.select(checkstation);
    }
}
