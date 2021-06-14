package com.reverie.service;

import com.reverie.domain.Car;
import com.reverie.domain.User;

import java.util.List;

public interface CarService {
    public Car selectByKey(String platenumber);

    public List<Car> selectAll();

    public List<Car> searchByPlateNumber(String plateNumber);

    public List<Car> searchByName(String name);

    public int delete(String platenumber);

    public int deleteList(List<String> platenumber);

    public int save(Car car);

    public int update(Car car);

    public int changeStatus(String platenumber, String status);
}
