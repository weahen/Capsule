package com.dtxw.mapper;

import com.dtxw.entity.RoomManager;
import com.dtxw.model.RegistInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomManagerMapper {

    @Select("select * from RoomManager")
    List<RoomManager> getAllRoomManager();

    @Select("select * from RoomManager where NAME=#{name}")
    RoomManager getRoomManagerByName(String name);

    @Insert("insert into RoomManager(NAME,PASSWORD,EMAIL) values (#{name},#{psw},#{email})")
    void AddRoomManager(String name,String psw,String email);

}
