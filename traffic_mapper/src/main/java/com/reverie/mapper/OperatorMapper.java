package com.reverie.mapper;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Operator;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface OperatorMapper extends Mapper<Operator> {
    @Select("select a.*,b.roleName FROM db_traffic.operator a join db_traffic.role b where a.jobNumber=#{jobNumber} and a.rid=b.rid")
    @Results({
            @Result(id = true,column = "jobnumber",property = "jobnumber"),
            @Result(column = "password",property = "password"),
            @Result(column = "rid",property = "rid"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "department",property = "department"),
            @Result(column = "vaild",property = "vaild"),
            @Result(column = "roleName",property = "role.roleName"),
    })
    public Operator loginSelect(String jobNumber);
}
