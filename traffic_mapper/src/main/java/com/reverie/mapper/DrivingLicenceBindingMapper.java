package com.reverie.mapper;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Drivinglicencebinding;
import com.reverie.domain.Userplateapply;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface DrivingLicenceBindingMapper extends Mapper<Drivinglicencebinding> {

    @Select("select COUNT(*) from drivinglicencebinding where username=#{username}")
    public String getMaxNumber(String username);

    @Select("select b.* FROM db_traffic.drivinglicencebinding a join db_traffic.drivinglicence b where a.username=#{username} and a.username=b.username")
    @Results({
            @Result(id = true,column = "dlnumber",property = "dlnumber"),
            @Result(column = "name",property = "name"),
            @Result(column = "nationality",property = "nationality"),
            @Result(column = "address",property = "address"),
            @Result(column = "birth",property = "birth"),
            @Result(column = "first_date",property = "firstDate"),
            @Result(column = "vehicle_type",property = "vehicleType"),
            @Result(column = "start_date",property = "startDate"),
            @Result(column = "end_date",property = "endDate"),
            @Result(column = "authority",property = "authority"),
            @Result(column = "score",property = "score"),
            @Result(column = "username",property = "username"),
            @Result(column = "status",property = "status"),
    })
    public Drivinglicence selectByUser(String username);
}
