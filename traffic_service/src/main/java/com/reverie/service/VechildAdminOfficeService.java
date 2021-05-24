package com.reverie.service;

import com.reverie.domain.Vechileadminoffice;

import java.util.List;

public interface VechildAdminOfficeService {
    public List<Vechileadminoffice> selectByProvince(String province);

    public Vechileadminoffice select(Vechileadminoffice vechileadminoffice);
}
