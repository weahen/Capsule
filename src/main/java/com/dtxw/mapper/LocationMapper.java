package com.dtxw.mapper;

import com.dtxw.entity.Locationtofield;
import com.dtxw.entity.room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocationMapper {
    @Select("SELECT * FROM LocationToField")
    List<Locationtofield> getAll();


}
