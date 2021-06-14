package com.reverie.mapper;

import com.reverie.domain.Checkreservation;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface CheckreservationMapper extends Mapper<Checkreservation> {

    @Select("select max(reserve_number) from checkreservation where reserve_number like #{date}")
    public String getMaxNumber(String date);

    @Select("select * from checkreservation where reserve_number like #{reserveNumber}" )
    @Results({
            @Result(id = true,column = "reserve_number",property = "reserveNumber"),
            @Result(column = "plate_number",property = "plateNumber"),
            @Result(column = "owner",property = "owner"),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "driving_type",property = "drivingType"),
            @Result(column = "fuel_type",property = "fuelType"),
            @Result(column = "check_station",property = "checkStation"),
            @Result(column = "check_date",property = "checkDate"),
            @Result(column = "start_time",property = "startTime"),
            @Result(column = "end_time",property = "endTime"),
            @Result(column = "username",property = "username"),
            @Result(column = "reserve_date",property = "reserveDate"),
            @Result(column = "status",property = "status"),
    })
    List<Checkreservation> searchByReverseNumber(String reserveNumber);

    @Select("select * from checkreservation where username like #{username}" )
    @Results({
            @Result(id = true,column = "reserve_number",property = "reserveNumber"),
            @Result(column = "plate_number",property = "plateNumber"),
            @Result(column = "owner",property = "owner"),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "driving_type",property = "drivingType"),
            @Result(column = "fuel_type",property = "fuelType"),
            @Result(column = "check_station",property = "checkStation"),
            @Result(column = "check_date",property = "checkDate"),
            @Result(column = "start_time",property = "startTime"),
            @Result(column = "end_time",property = "endTime"),
            @Result(column = "username",property = "username"),
            @Result(column = "reserve_date",property = "reserveDate"),
            @Result(column = "status",property = "status"),
    })
    List<Checkreservation> searchByUser(String username);
}
