package com.reverie.mapper;

import com.reverie.domain.Platenumber;
import com.reverie.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface PlatenumberMapper extends Mapper<Platenumber> {
    /**
     * @Description: 批量删除车牌号
     * @Date:
     * @Author:
     */
    @Delete("<script> delete from platenumber where plate_number in"+
            "<foreach collection=\"list\" item=\"plateNumber\" open=\"(\" close=\")\" separator=\",\">"+
            "#{plateNumber}"+
            "</foreach>"+
            "</script>")
    public int deletePlateNumberList(List<String> plateNumberList);

    @Select("select * from platenumber where plate_number like #{platenumber}")
    @Results({
            @Result(column = "plate_number",property = "plateNumber",id = true),
            @Result(column = "issue_date",property = "issueDate"),
            @Result(column = "status",property = "status"),
            @Result(column = "location_name",property = "locationName"),
            @Result(column = "province",property = "province"),
            @Result(column = "city",property = "city"),
            @Result(column = "plate_head",property = "plateHead"),
    })
    public List<Platenumber> findPlateNumberLike(String platenumber);
}
