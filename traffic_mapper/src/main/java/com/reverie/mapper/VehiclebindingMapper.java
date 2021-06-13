package com.reverie.mapper;

import com.reverie.domain.Car;
import com.reverie.domain.Vehiclebinding;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface VehiclebindingMapper extends Mapper<Vehiclebinding> {

    @Select("select b.* FROM db_traffic.vehiclebinding a join db_traffic.car b where a.username=#{username} and a.plate_number=b.plate_number")
    @Results({
            @Result(id = true,column = "plate_number",property = "plateNumber"),
            @Result(column = "color",property = "color"),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "factory_plate_model",property = "factoryPlateModel"),
            @Result(column = "VIN",property = "vin"),
            @Result(column = "engine_number",property = "engineNumber"),
            @Result(column = "status",property = "status"),
    })
    public List<Car> selectCarByUser(String username);

    @Select("select max(vb_number) from vehiclebinding where vb_number like #{date}")
    public String getMaxNumber(String date);
}
