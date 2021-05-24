package com.reverie.service;

import com.reverie.domain.Trafficoffence;

import java.util.List;

public interface TrafficOffenceService {

    public List<Trafficoffence> selectByCar(String plateNumber);

    public List<Trafficoffence> selectAll();

    public Trafficoffence selectById(String trafficOffenceNumber);

    public boolean handleIllegal(String username,int score,String trafficOffenceNumber,String status);

    public int save(Trafficoffence trafficoffence);

    public int update(Trafficoffence trafficoffence);

}
