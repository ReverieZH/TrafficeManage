package com.reverie.mapper;


import com.reverie.domain.Car;
import com.reverie.domain.Vehiclelicense;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface CarMapper extends Mapper<Car> {

    @Select("select * from car where plate_number like #{plateNumber}")
    @Results({
            @Result(column = "plate_number",property = "plateNumber",id = true),
            @Result(column = "color",property = "color"),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "factory_plate_model",property = "factoryPlateModel"),
            @Result(column = "produce_date",property = "produceDate"),
            @Result(column = "produce_place",property = "producePlace"),
            @Result(column = "vin",property = "vin"),
            @Result(column = "engine_number",property = "engineNumber"),
            @Result(column = "status",property = "status"),
            @Result(column = "registrant",property = "registrant"),
            @Result(column = "certificate_number",property = "certificateNumber"),
            @Result(column = "registation_date",property = "registationDate"),
    })
    public List<Car> searchByPlateNumber(String plateNumber);

    @Select("select * from car where name like #{name}")
    @Results({
            @Result(column = "plate_number",property = "plateNumber",id = true),
            @Result(column = "color",property = "color"),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "factory_plate_model",property = "factoryPlateModel"),
            @Result(column = "produce_date",property = "produceDate"),
            @Result(column = "produce_place",property = "producePlace"),
            @Result(column = "vin",property = "vin"),
            @Result(column = "engine_number",property = "engineNumber"),
            @Result(column = "status",property = "status"),
            @Result(column = "registrant",property = "registrant"),
            @Result(column = "certificate_number",property = "certificateNumber"),
            @Result(column = "registation_date",property = "registationDate"),
    })
    public List<Car> searchByName(String name);
}
