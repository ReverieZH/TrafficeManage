package com.reverie.mapper;

import com.reverie.domain.Losereplace;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface LosereplaceMapper extends Mapper<Losereplace> {

    @Select("select max(lose_replace_number) from losereplace where lose_replace_number like #{date}")
    public String getMaxNumber(String date);

    @Select("select * from losereplace where lose_replace_number like #{loseReplaceNumber}" )
    @Results({
            @Result(id = true,column = "lose_replace_number",property = "loseReplaceNumber"),
            @Result(column = "dl_number",property = "dlNumber"),
            @Result(column = "access_method",property = "accessMethod"),
            @Result(column = "receiver_name",property = "receiverName"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "address",property = "address"),
            @Result(column = "post_code",property = "postCode"),
            @Result(column = "pay_status",property = "payStatus"),
            @Result(column = "username",property = "username"),
            @Result(column = "apply_date",property = "applyDate"),
            @Result(column = "status",property = "status"),
            @Result(column = "area",property = "area"),
    })
    List<Losereplace> searchByLoseReplaceNumber(String loseReplaceNumber);

    @Select("select * from losereplace where username like #{username}" )
    @Results({
            @Result(id = true,column = "lose_replace_number",property = "loseReplaceNumber"),
            @Result(column = "dl_number",property = "dlNumber"),
            @Result(column = "access_method",property = "accessMethod"),
            @Result(column = "receiver_name",property = "receiverName"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "address",property = "address"),
            @Result(column = "post_code",property = "postCode"),
            @Result(column = "pay_status",property = "payStatus"),
            @Result(column = "username",property = "username"),
            @Result(column = "apply_date",property = "applyDate"),
            @Result(column = "status",property = "status"),
            @Result(column = "area",property = "area"),
    })
    List<Losereplace> searchByUser(String username);
}
