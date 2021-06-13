package com.reverie.mapper;

import com.reverie.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
@Repository
public interface SyslogMapper extends Mapper<Syslog> {
    /**
     * 新增一条日志信息
     * @param syslog
     */
    @Insert("insert into syslog(visit_time,jobnumber,ip,url,execution_time,method) values " +
            "(#{visitTime},#{jobnumber},#{ip},#{url},#{executionTime},#{method})")
    public void save(Syslog syslog);

    /**
     * 查询所有日志信息
     * @return
     */
    @Select("select * from syslog")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "visit_time",property = "visitTime"),
            @Result(column = "jobnumber",property = "jobnumber"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "url",property = "url"),
            @Result(column = "execution_time",property = "executionTime"),
            @Result(column = "method",property = "method"),
    })
    public List<Syslog> findAll();

    @Select("select * from syslog where jobnumber=#{jobnumber}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "visit_time",property = "visitTime"),
            @Result(column = "jobnumber",property = "jobnumber"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "url",property = "url"),
            @Result(column = "execution_time",property = "executionTime"),
            @Result(column = "method",property = "method"),
    })
    public List<Syslog> findByJobNumber(String jobnumber);
}
