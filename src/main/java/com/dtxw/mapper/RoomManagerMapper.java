package com.dtxw.mapper;

import com.dtxw.entity.RegistCache;
import com.dtxw.entity.RoomManager;
import com.dtxw.model.RegistInfo;
import org.apache.ibatis.annotations.Delete;
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

    @Select("select * from regist_cache where NAME=#{name}")
    RoomManager getCacheByName(String name);

    @Insert("insert into regist_cache(NAME,PASSWORD,EMAIL) values (#{name},#{psw},#{email})")
    void AddToCache(String name,String psw,String email);

    @Select("SELECT * FROM regist_cache")
    List<RegistCache> getCache();

    @Insert("insert into roommanager(NAME,PASSWORD,EMAIL,ACCESSFIELD) values (#{name},#{psw},#{email},#{accessfield})")
    void AddManager(String name,String psw,String email,String accessfield);

    @Delete("delete from regist_cache where NAME=#{name}")
    void deleteCacheByName(String name);


}
