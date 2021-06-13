package com.reverie.service;

import com.reverie.domain.Platenumber;
import com.reverie.domain.User;

import java.util.List;

public interface PlateNumberService {
    public Platenumber selectByKey(String plateNumber);

    public List<Platenumber> selectAll();

    public List<Platenumber> findPlateNumberLike(String platenumberStr);

    public List<Platenumber> selectUsableNumber(String province,String city);

    public int delete(String plateNumber);

    public int deleteList(List<String> plateNumbers);

    public int save(Platenumber plateNumber);

    public int update(Platenumber plateNumber);

    public int changeStatus(String plateNumber,String status);
}
