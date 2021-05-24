package com.reverie.service;

import com.reverie.domain.Vehiclelicense;

import java.util.List;

public interface VehiclelicenseService {
    public Vehiclelicense selectByKey(String clnumber);

    public List<Vehiclelicense> selectAll();

    public int delete(String clnumber);

    public int deleteList(List<String> vehiclelicense);

    public int save(Vehiclelicense vehiclelicense);

    public int update(Vehiclelicense vehiclelicense);

    public int changeStatus(String dlnumber, String status);
}
