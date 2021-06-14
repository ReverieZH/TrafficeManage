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


    @Select("select * from applyexemptedcheck where acNumber like #{acNumber}" )
    @Results({
            @Result(id = true,column = "ac_number",property = "acNumber"),
            @Result(column = "plate_number",property = "plateNumber"),
            @Result(column = "vehicle_proof",property = "vehicleProof"),
            @Result(column = "insurance_photo",property = "insurancePhoto"),
            @Result(column = "tax_photo",property = "taxPhoto"),
            @Result(column = "end_date",property = "endDate"),
            @Result(column = "is_need_paper",property = "isNeedPaper"),
            @Result(column = "access_method",property = "accessMethod"),
            @Result(column = "receiver_name",property = "receiverName"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "address",property = "address"),
            @Result(column = "post_code",property = "postCode"),
            @Result(column = "paystatus",property = "paystatus"),
            @Result(column = "username",property = "username"),
            @Result(column = "apply_date",property = "applyDate"),
            @Result(column = "status",property = "status"),
            @Result(column = "area",property = "area"),
    })
    public List<Applyexemptedcheck> searchByAcNumber(String acNumber);

    @Select("select * from applyexemptedcheck where username like #{username}" )
    @Results({
            @Result(id = true,column = "ac_number",property = "acNumber"),
            @Result(column = "plate_number",property = "plateNumber"),
            @Result(column = "vehicle_proof",property = "vehicleProof"),
            @Result(column = "insurance_photo",property = "insurancePhoto"),
            @Result(column = "tax_photo",property = "taxPhoto"),
            @Result(column = "end_date",property = "endDate"),
            @Result(column = "is_need_paper",property = "isNeedPaper"),
            @Result(column = "access_method",property = "accessMethod"),
            @Result(column = "receiver_name",property = "receiverName"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "address",property = "address"),
            @Result(column = "post_code",property = "postCode"),
            @Result(column = "paystatus",property = "paystatus"),
            @Result(column = "username",property = "username"),
            @Result(column = "apply_date",property = "applyDate"),
            @Result(column = "status",property = "status"),
            @Result(column = "area",property = "area"),
    })
    public List<Applyexemptedcheck> searchByUser(String username);

    @Select("select max(ac_number) from applyexemptedcheck where ac_number like #{date}")
    public String getMaxNumber(String date);
}
