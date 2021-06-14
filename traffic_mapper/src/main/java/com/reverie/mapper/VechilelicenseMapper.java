package com.reverie.mapper;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Vehiclelicense;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface VechilelicenseMapper extends Mapper<Vehiclelicense> {
    @Select("select max(vlnumber) from vehiclelicense where vlnumber like #{date}")
    public String getMaxNumber(String date);

    @Select("select * from vehiclelicense where owner like #{name}")
    @Results({
            @Result(column = "vlnumber",property = "vlnumber",id = true),
            @Result(column = "plate_number",property = "plateNumber"),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "owner",property = "owner"),
            @Result(column = "address",property = "address"),
            @Result(column = "brand_model",property = "brandModel"),
            @Result(column = "vin",property = "vin"),
            @Result(column = "engine_number",property = "engineNumber"),
            @Result(column = "registation_date",property = "registationDate"),
            @Result(column = "issue_date",property = "issueDate"),
            @Result(column = "status",property = "status"),
    })
    public List<Vehiclelicense> searchByName(String name);
}
