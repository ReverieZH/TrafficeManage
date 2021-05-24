package com.reverie.service.impl;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Drivinglicencebinding;
import com.reverie.mapper.DrivingLicenceBindingMapper;
import com.reverie.service.DrivingLicenceBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DrivingLicenceBindingServiceImpl implements DrivingLicenceBindingService{
    @Autowired
    private DrivingLicenceBindingMapper drivingLicenceBindingMapper;

    @Override
    public int selectCountByUser(String username) {
        Drivinglicencebinding drivinglicencebinding=new Drivinglicencebinding();
        drivinglicencebinding.setUsername(username);
        return drivingLicenceBindingMapper.selectCount(drivinglicencebinding);
    }

    @Override
    public int save(String dlNumber,String username) {
        Drivinglicencebinding drivinglicencebinding=new Drivinglicencebinding();
        drivinglicencebinding.setDlnumber(dlNumber);
        drivinglicencebinding.setUsername(username);
        return drivingLicenceBindingMapper.insert(drivinglicencebinding);
    }

    @Override
    public Drivinglicence selectByUser(String username) {
        return drivingLicenceBindingMapper.selectByUser(username);
    }
}
