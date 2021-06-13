package com.reverie.mapper;

import com.reverie.domain.Applyexemptedcheck;
import com.reverie.domain.Platenumberapply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @Description: 申请免检Mapper接口
* @Date:
* @Author:
*/
@org.apache.ibatis.annotations.Mapper
@Repository
public interface ApplyExemptedCheckMapper extends Mapper<Applyexemptedcheck> {

    @Select("<script>" +
            "select * from applyexemptedcheck"+
            "<where>"+
            "<if test=\"status !=null\" > and status=#{status}</if>"+
            "</where>"+
            "</script>")
    @Results({
            @Result(id = true,column = "apply_number",property = "applyNumber"),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "vehicle_proof",property = "vehicleProof"),
            @Result(column = "certificate_number",property = "certificateNumber"),
            @Result(column = "brand_model",property = "brandModel"),
            @Result(column = "vin",property = "vin"),
            @Result(column = "optional_plate_head",property = "optionalPlateHead"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "username",property = "username"),
            @Result(column = "status",property = "status"),
    })
    public List<Applyexemptedcheck> selectList(@Param("status") String status);


    @Select("select max(ac_number) from applyexemptedcheck where ac_number like #{date}")
    public String getMaxNumber(String date);
}
