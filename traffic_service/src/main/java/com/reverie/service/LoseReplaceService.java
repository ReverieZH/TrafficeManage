package com.reverie.service;

import com.reverie.domain.Losereplace;

import java.util.List;

public interface LoseReplaceService {

    public String save(Losereplace losereplace);

    public List<Losereplace> selectAll();

    public List<Losereplace>  selectApplying();

    public Losereplace selectById(String loseReplaceNumber);

    public int handle(String loseReplaceNumber,String status);
}
