package com.reverie.service;

import com.reverie.domain.Applyednumber;

import java.util.List;

public interface ApplyedNumberService {

    public List<Applyednumber> selectPlateNumber(String username);

    public int save(Applyednumber applyednumber);
}
