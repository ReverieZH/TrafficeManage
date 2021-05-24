package com.reverie.mapper;

import com.reverie.domain.Checkreservation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface CheckreservationMapper extends Mapper<Checkreservation> {

    @Select("select max(reserve_number) from checkreservation where reserve_number like #{date}")
    public String getMaxNumber(String date);
}
