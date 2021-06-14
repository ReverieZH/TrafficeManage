package com.reverie.mapper;


import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Syslog;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface DrivinglicenceMapper extends Mapper<Drivinglicence> {

    @Select("select max(dlnumber) from drivinglicence where dlnumber like #{date}")
    public String getMaxNumber(String date);

    @Select("select * from drivinglicence where name like #{name}")
    @Results({
            @Result(column = "dlnumber",property = "dlnumber",id = true),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "nationality",property = "nationality"),
            @Result(column = "address",property = "address"),
            @Result(column = "first_date",property = "firstDate"),
            @Result(column = "vehicle_type",property = "vehicleType"),
            @Result(column = "vehicle_type",property = "vehicleType"),
            @Result(column = "start_date",property = "startDate"),
            @Result(column = "end_date",property = "endDate"),
            @Result(column = "score",property = "score"),
            @Result(column = "username",property = "username"),
            @Result(column = "status",property = "status"),
    })
    public List<Drivinglicence> searchByName(String name);
}
