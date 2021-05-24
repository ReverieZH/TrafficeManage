package com.reverie.mapper;

import com.reverie.domain.Userplateapply;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserPlateApplyMapper extends Mapper<Userplateapply> {
    //    SELECT a.id ,a.username ,b.* FROM db_traffic.userplateapply a  natural  join db_traffic.platenumberapply b where a.apply_number=b.apply_number;
    @Select("select a.id ,a.username ,b.* FROM db_traffic.userplateapply a natural join db_traffic.platenumberapply b where username=#{username} and  a.apply_number=b.apply_number")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "apply_number",property = "applyNumber"),
            @Result(column = "car_type",property = "platenumberapply.carType"),
            @Result(column = "vehicle_proof",property = "platenumberapply.vehicleProof"),
            @Result(column = "certificate_number",property = "platenumberapply.certificateNumber"),
            @Result(column = "brand_model",property = "platenumberapply.brandModel"),
            @Result(column = "VIN",property = "platenumberapply.vin"),
            @Result(column = "optional_plate_head",property = "platenumberapply.optionalPlateHead"),
            @Result(column = "owner",property = "platenumberapply.owner"),
            @Result(column = "status",property = "platenumberapply.status"),
    })
    public Userplateapply selectPalteApply(String username);

}
