package com.reverie.service;

import com.reverie.domain.Checkreservation;

import java.util.List;

public interface CheckReservationService {

    public String save(Checkreservation checkreservation);

    public List<Checkreservation> selectByUsername(String username);

    public List<Checkreservation> selectAll();

    public List<Checkreservation> selectApplying();

    public Checkreservation selecyById(String reserveNumber);

    public int handle(String reserveNumber,String status);
}
