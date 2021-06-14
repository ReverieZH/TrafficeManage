package com.reverie.service.impl;

import com.reverie.domain.Car;
import com.reverie.mapper.CarMapper;
import com.reverie.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Car selectByKey(String platenumber) {
        return carMapper.selectByPrimaryKey(platenumber);
    }

    @Override
    public List<Car> selectAll() {
        return carMapper.selectAll();
    }

    @Override
    public List<Car> searchByPlateNumber(String plateNumberStr) {
        String plateNumber="%"+plateNumberStr+"%";
        return carMapper.searchByPlateNumber(plateNumber);
    }

    @Override
    public List<Car> searchByName(String nameStr) {
        String name="%"+nameStr+"%";
        return carMapper.searchByName(name);
    }

    @Override
    public int delete(String platenumber) {
        return carMapper.deleteByPrimaryKey(platenumber);
    }

    @Override
    public int deleteList(List<String> platenumber) {
        return 0;
    }

    @Override
    public int save(Car car) {
        return carMapper.insert(car);
    }

    @Override
    public int update(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public int changeStatus(String platenumber, String status) {
        Car car=new Car();
        car.setPlateNumber(platenumber);
        car.setStatus(status);
        return carMapper.updateByPrimaryKeySelective(car);
    }
}
