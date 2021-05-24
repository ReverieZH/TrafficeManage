package com.reverie.service;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Drivinglicencebinding;

public interface DrivingLicenceBindingService {

    public int selectCountByUser(String username);

    public int save(String dlNumber,String username);

    public Drivinglicence selectByUser(String username);
}
