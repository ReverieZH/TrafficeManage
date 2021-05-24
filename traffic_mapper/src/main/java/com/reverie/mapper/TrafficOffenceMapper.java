package com.reverie.mapper;

import com.reverie.domain.Trafficoffence;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface TrafficOffenceMapper extends Mapper<Trafficoffence> {

    @Select("select max(traffic_offence_number) from trafficoffence where traffic_offence_number like #{date}")
    public String getMaxNumber(String date);
}
