package com.reverie.mapper;


import com.reverie.domain.Drivinglicence;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface DrivinglicenceMapper extends Mapper<Drivinglicence> {

    @Select("select max(dlnumber) from drivinglicence where dlnumber like #{date}")
    public String getMaxNumber(String date);

}
