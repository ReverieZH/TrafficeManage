package com.reverie.service.impl;

import com.reverie.domain.Platenumber;
import com.reverie.domain.User;
import com.reverie.mapper.PlatenumberMapper;
import com.reverie.service.PlateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("plateNumberService")
public class PlateNumberServiceImpl implements PlateNumberService {
    @Autowired
    private PlatenumberMapper platenumberMapper;
    @Override
    public Platenumber selectByKey(String plateNumber) {
        return platenumberMapper.selectByPrimaryKey(plateNumber);
    }

    @Override
    public List<Platenumber> selectAll() {
        return platenumberMapper.selectAll();
    }

    @Override
    public List<Platenumber> findPlateNumberLike(String platenumberStr) {
        String plateNumber="%"+platenumberStr+"%";
        return platenumberMapper.findPlateNumberLike(plateNumber);
    }

    @Override
    public List<Platenumber> selectUsableNumber(String province,String city) {
        Platenumber platenumber=new Platenumber();
        platenumber.setStatus("1");
        platenumber.setProvince(province);
        platenumber.setCity(city);
        return platenumberMapper.select(platenumber);
    }

    @Override
    public int delete(String plateNumber) {
        return platenumberMapper.deleteByPrimaryKey(plateNumber);
    }

    @Override
    public int deleteList(List<String> plateNumbers) {
        return platenumberMapper.deletePlateNumberList(plateNumbers);
    }

    @Override
    public int save(Platenumber plateNumber) {
        return platenumberMapper.insert(plateNumber);
    }

    @Override
    public int update(Platenumber plateNumber) {
        return platenumberMapper.updateByPrimaryKeySelective(plateNumber);
    }

    @Override
    public int changeStatus(String plateNumber, String status) {
        Platenumber platenumber=new Platenumber();
        platenumber.setPlateNumber(plateNumber);
        platenumber.setStatus(status);
        return platenumberMapper.updateByPrimaryKeySelective(platenumber);
    }
}
