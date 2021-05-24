package com.reverie.mapper;

import com.reverie.domain.Platenumber;
import org.apache.ibatis.annotations.Delete;
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
}
