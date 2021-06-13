package com.reverie.mapper;

import com.reverie.domain.Changelicence;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface ChangelicenceMapper extends Mapper<Changelicence> {
}
