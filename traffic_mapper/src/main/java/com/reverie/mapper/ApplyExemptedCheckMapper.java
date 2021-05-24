package com.reverie.mapper;

import com.reverie.domain.Applyexemptedcheck;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
* @Description: 申请免检Mapper接口
* @Date:
* @Author:
*/
@org.apache.ibatis.annotations.Mapper
@Repository
public interface ApplyExemptedCheckMapper extends Mapper<Applyexemptedcheck> {
    @Select("select max(ac_number) from applyexemptedcheck where ac_number like #{date}")
    public String getMaxNumber(String date);
}
