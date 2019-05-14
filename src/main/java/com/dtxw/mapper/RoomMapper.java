package com.dtxw.mapper;

import com.dtxw.entity.room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper {

    @Select("select * from Room where ID=#{id}")
    room getRoomById(Integer id);

    @Select("select * from Room")
    List<room> getAllRoom();

    @Select("select NAME from Room ")
    List<String> getRoomNameList();

    @Select("SELECT * FROM Room WHERE NAME=#{name}")
    room getRoomByName(String name);

    @Insert("insert into Room(NAME,PATH,FIELD,START_TIME,END_TIME,LOCATION) values (#{NAME},#{PATH},#{FIELD},#{START_TIME},#{END_TIME},#{LOCATION})")
    int addRoom(room r);

    @Select("SELECT room.ID,`NAME`,PATH,room.FIELD,START_TIME,END_TIME,LOCATION FROM fieldtomac INNER JOIN room ON fieldtomac.FIELD=room.FIELD where MAC=#{mac} AND END_TIME>NOW();")
    List<room> selectByMac(String mac);

    @Select("SELECT * FROM room WHERE END_TIME>NOW();")
    List<room> getEndTime();

}
