package com.reverie.service.impl;

import com.reverie.domain.Vechileadminoffice;
import com.reverie.domain.Vehiclelicense;
import com.reverie.mapper.VechildAdminOfficeMapper;
import com.reverie.service.VechildAdminOfficeService;
import com.reverie.service.VehiclelicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vechildAdminOfficeService")
public class VechildAdminOfficeServiceImpl implements VechildAdminOfficeService {

    @Autowired
    private VechildAdminOfficeMapper vechildAdminOfficeMapper;

    @Override
    public List<Vechileadminoffice> selectByProvince(String province) {
        Vechileadminoffice vechileadminoffice=new Vechileadminoffice();
        vechileadminoffice.setProvince(province);
        return vechildAdminOfficeMapper.select(vechileadminoffice);
    }

    @Override
    public Vechileadminoffice select(Vechileadminoffice vechileadminoffice) {
        return vechildAdminOfficeMapper.selectOne(vechileadminoffice);
    }


}
