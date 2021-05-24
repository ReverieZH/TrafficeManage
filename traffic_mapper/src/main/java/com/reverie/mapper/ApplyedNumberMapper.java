package com.reverie.mapper;

import com.reverie.domain.Applyednumber;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface ApplyedNumberMapper extends Mapper<Applyednumber> {


    @Select("select max(applyednumberid) from applyednumber where applyednumberid like #{date}")
    public String getMaxNumber(String date);
}
