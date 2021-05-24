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
    @Insert("insert into tb_syslog(visit_time,job_number,ip,url,execution_time,method) values " +
            "(#{visitTime},#{jobNumber},#{ip},#{url},#{executionTime},#{method})")
    public void save(Syslog syslog);

    /**
     * 查询所有日志信息
     * @return
     */
    @Select("select * from tb_syslog")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "visit_time",property = "visitTime"),
            @Result(column = "job_number",property = "jobNumber"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "url",property = "url"),
            @Result(column = "execution_time",property = "executionTime"),
            @Result(column = "method",property = "method"),
    })
    public List<Syslog> findAll();

    @Select("select * from tb_syslog where job_number like #{jobNumberStr}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "visit_time",property = "visitTime"),
            @Result(column = "job_number",property = "jobNumber"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "url",property = "url"),
            @Result(column = "execution_time",property = "executionTime"),
            @Result(column = "method",property = "method"),
    })
    public List<Syslog> findByJobNumber(String jobNumberStr);
}
