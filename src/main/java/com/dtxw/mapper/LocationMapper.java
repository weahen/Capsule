package com.dtxw.mapper;

import com.dtxw.entity.Fieldtomac;
import com.dtxw.entity.Locationtofield;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocationMapper {
    @Select("SELECT * FROM LocationToField")
    List<Locationtofield> getAll();

    @Insert("insert into fieldtomac(MAC,FIELD) values (#{mac},#{field})")
    int addMAC(Fieldtomac fieldtomac);

    @Insert("insert into locationtofield(LOCATION,FIELD) values (#{location},#{field})")
    int addLocation(Locationtofield locationtofield);

    @Select("select * from fieldtomac where FIELD=#{id}")
    List<Fieldtomac> selectFieldtomacById(int id);
}
