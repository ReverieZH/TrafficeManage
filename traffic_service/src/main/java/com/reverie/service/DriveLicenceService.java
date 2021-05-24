package com.reverie.service;

import com.reverie.domain.Drivinglicence;

import java.util.List;

public interface DriveLicenceService {
    public Drivinglicence selectByKey(String dlnumber);

    public List<Drivinglicence> selectAll();

    public int delete(String dlnumber);

    public int deleteList(List<String> drivinglicence);

    public int save(Drivinglicence drivinglicence);

    public int update(Drivinglicence drivinglicence);

    public int changeStatus(String dlnumber, String status);
}
