package com.reverie.mapper;

import com.reverie.domain.Checkreservation;
import com.reverie.domain.Trafficoffence;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface TrafficOffenceMapper extends Mapper<Trafficoffence> {

    @Select("select max(traffic_offence_number) from trafficoffence where traffic_offence_number like #{date}")
    public String getMaxNumber(String date);

    @Select("select * from trafficoffence where plate_number like #{plateNumber}" )
    @Results({
            @Result(id = true,column = "traffic_offence_number",property = "trafficOffenceNumber"),
            @Result(column = "traffic_offence_date",property = "trafficOffenceDate"),
            @Result(column = "traffic_offence_place",property = "trafficOffencePlace"),
            @Result(column = "traffic_offence_act",property = "trafficOffenceAct"),
            @Result(column = "score",property = "score"),
            @Result(column = "money",property = "money"),
            @Result(column = "pay_date",property = "payDate"),
            @Result(column = "dl_number",property = "dlNumber"),
            @Result(column = "plate_number",property = "plateNumber"),
            @Result(column = "punish_office",property = "punishOffice"),
            @Result(column = "status",property = "status"),
            @Result(column = "need_window",property = "needWindow"),
    })
    List<Trafficoffence> searchByPlate(String plateNumber);


    @Select("select * from trafficoffence where traffic_offence_number like #{trafficOffenceNumber}" )
    @Results({
            @Result(id = true,column = "traffic_offence_number",property = "trafficOffenceNumber"),
            @Result(column = "traffic_offence_date",property = "trafficOffenceDate"),
            @Result(column = "traffic_offence_place",property = "trafficOffencePlace"),
            @Result(column = "traffic_offence_act",property = "trafficOffenceAct"),
            @Result(column = "score",property = "score"),
            @Result(column = "money",property = "money"),
            @Result(column = "pay_date",property = "payDate"),
            @Result(column = "dl_number",property = "dlNumber"),
            @Result(column = "plate_number",property = "plateNumber"),
            @Result(column = "punish_office",property = "punishOffice"),
            @Result(column = "status",property = "status"),
            @Result(column = "need_window",property = "needWindow"),
    })
    List<Trafficoffence> searchById(String trafficOffenceNumber);
}
