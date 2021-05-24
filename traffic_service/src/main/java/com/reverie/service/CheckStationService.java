package com.reverie.service;

import com.reverie.domain.Checkstation;

import java.util.List;

public interface CheckStationService {

    public List<Checkstation> selectAll();

    public List<Checkstation> selectByProvince(String province);

    public List<Checkstation> selectByProvinceAndCity(String province,String city);



}
