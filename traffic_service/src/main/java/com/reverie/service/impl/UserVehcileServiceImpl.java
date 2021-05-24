package com.reverie.service.impl;

import com.reverie.domain.Car;
import com.reverie.domain.Uservehcile;
import com.reverie.mapper.UserVehcileMapper;
import com.reverie.service.UserVehcileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVehcileServiceImpl implements UserVehcileService {
    @Autowired
    private UserVehcileMapper userVehcileMapper;

    @Override
    public int bind(String username, String plateNumber) throws Exception {
        Uservehcile uservehcile=new Uservehcile();
        uservehcile.setUsername(username);
        uservehcile.setPlateNumber(plateNumber);
        return userVehcileMapper.insert(uservehcile);
    }

    @Override
    public List<Car> selectCarByUser(String username) {
        return userVehcileMapper.selectCarByUser(username);
    }
}
