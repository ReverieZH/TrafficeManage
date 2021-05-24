package com.reverie.service;

import com.reverie.domain.Platenumber;
import com.reverie.domain.Platenumberapply;

import java.util.List;

public interface PlateNumberApplyService {
    public Platenumberapply selectByKey(String applyNumber);

    public List<Platenumberapply> selectAll();

    public List<Platenumberapply> selectCondiion(String status);

    public List<Platenumberapply> selectByUsername(String username);

    public int delete(String applyNumber);

    public int deleteList(List<String> applyNumbers);

    public String save(Platenumberapply platenumberapply);

    public int update(Platenumberapply platenumberapply);

    public int changeStatus(String plateNumber,String status);

    public int handle(String applyNumber);
}
