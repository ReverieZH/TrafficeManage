package com.reverie.mapper;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Platenumberapply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface PlatenumberapplyMapper extends Mapper<Platenumberapply> {

    @Select("<script>" +
            "select * from platenumberapply"+
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
    public List<Platenumberapply> selectList(@Param("status") String status);

    @Select("select max(apply_number) from platenumberapply where apply_number like #{date}")
    public String getMaxNumber(String date);

    @Select("select * from platenumberapply where apply_number like #{applyNumber}")
    @Results({
            @Result(column = "apply_number",property = "applyNumber",id = true),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "vehicle_proof",property = "vehicleProof"),
            @Result(column = "certificate_number",property = "certificateNumber"),
            @Result(column = "brand_model",property = "brandModel"),
            @Result(column = "vin",property = "vin"),
            @Result(column = "optional_plate_head",property = "optionalPlateHead"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "username",property = "username"),
            @Result(column = "owner",property = "owner"),
            @Result(column = "status",property = "status"),
    })
    public List<Platenumberapply> searchByApplyNumber(String applyNumber);

    @Select("select * from platenumberapply where username like #{username}")
    @Results({
            @Result(column = "apply_number",property = "applyNumber",id = true),
            @Result(column = "car_type",property = "carType"),
            @Result(column = "vehicle_proof",property = "vehicleProof"),
            @Result(column = "certificate_number",property = "certificateNumber"),
            @Result(column = "brand_model",property = "brandModel"),
            @Result(column = "vin",property = "vin"),
            @Result(column = "optional_plate_head",property = "optionalPlateHead"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "username",property = "username"),
            @Result(column = "owner",property = "owner"),
            @Result(column = "status",property = "status"),
    })
    public List<Platenumberapply> searchByUser(String username);


}
