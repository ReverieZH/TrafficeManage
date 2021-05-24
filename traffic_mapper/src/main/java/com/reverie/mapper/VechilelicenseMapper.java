package com.reverie.mapper;

import com.reverie.domain.Vehiclelicense;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface VechilelicenseMapper extends Mapper<Vehiclelicense> {
    @Select("select max(vlnumber) from ehiclelicense where vlnumber like #{date}")
    public String getMaxNumber(String date);
}
