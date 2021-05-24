package com.reverie.mapper;

import com.reverie.domain.Losereplace;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface LosereplaceMapper extends Mapper<Losereplace> {

    @Select("select max(lose_replace_number) from losereplace where lose_replace_number like #{date}")
    public String getMaxNumber(String date);

}
