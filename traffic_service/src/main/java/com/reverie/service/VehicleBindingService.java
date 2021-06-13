package com.reverie.service;

import com.reverie.domain.Car;

import java.util.List;

public interface VehicleBindingService {

    public int bind(String username,String plateNumber) throws Exception;

    public List<Car> selectCarByUser(String username);
}
