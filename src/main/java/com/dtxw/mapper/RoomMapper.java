package com.dtxw.mapper;

import com.dtxw.entity.*;
import com.dtxw.model.modify_to_room_info;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper {

    @Select("select * from Room where ID=#{id}")
    room getRoomById(Integer id);

    @Select("select * from Room where FIELD=#{field}")
    List<room> getRoomByField(Integer field);

    @Select("select * from Room")
    List<room> getAllRoom();

    @Select("select NAME from Room ")
    List<String> getRoomNameList();

    @Select("SELECT * FROM Room WHERE NAME=#{name}")
    room getRoomByName(String name);

    @Insert("insert into Room(NAME,PATH,FIELD,START_TIME,END_TIME,LOCATION,RESERVE) values (#{NAME},#{PATH},#{FIELD},#{START_TIME},#{END_TIME},#{LOCATION},#{RESERVE})")
    int addRoom(room r);

    @Select("SELECT room.ID,`NAME`,PATH,room.FIELD,START_TIME,END_TIME,LOCATION,RESERVE FROM fieldtomac " +
            "INNER JOIN room ON fieldtomac.FIELD=room.FIELD where MAC=#{mac} AND END_TIME>NOW();")
    List<room> selectByMac(String mac);

    @Select("SELECT * FROM room WHERE END_TIME>NOW();")
    List<room> getEndTime();

    @Insert("insert into reserve(NAME,CURRENT_NO,TOTAL_NO,TYPE,PATH) values (#{NAME},#{CURRENT_No},#{TOTAL_No},#{TYPE},#{PATH})")
    int addReserve(Reserve reserve);

    @Select("SELECT * from reserve where PATH=#{path}")
    Reserve getReserve(String path);

    @Update("update reserve set TOTAL_NO=#{total_no} where PATH=#{path}")
    int updateReserve(String path,int total_no);

    @Update("update reserve set CURRENT_NO=#{current} where PATH=#{path}")
    int updateCurrent(String path,int current);

    @Insert("insert into RESERVE_MULTIPLE(PATH,CURRENT_NO,TOTAL_NO,TYPE,TYPE_2,TYPE_4,TYPE_6,TYPE_8,TYPE_MORE,NAME) values (#{PATH},#{CURRENT_NO},#{TOTAL_NO},#{TYPE},#{TYPE_2},#{TYPE_4},#{TYPE_6},#{TYPE_8},#{TYPE_MORE},#{NAME})")
    int addMultipleReserve(Reserve_Multiple multiple);

    @Select("select * from RESERVE_MULTIPLE where PATH=#{path}")
    Reserve_Multiple getMultipleReserve(String path);

    @Update("update RESERVE_MULTIPLE set TOTAL_NO=#{reserve_multiple.TOTAL_NO},CURRENT_NO=#{reserve_multiple.CURRENT_NO},TYPE_2=#{reserve_multiple.TYPE_2},TYPE_4=#{reserve_multiple.TYPE_4},TYPE_6=#{reserve_multiple.TYPE_6},TYPE_8=#{reserve_multiple.TYPE_8},TYPE_MORE=#{reserve_multiple.TYPE_MORE} where PATH=#{path}")
    int updateMultipleReserve(Reserve_Multiple reserve_multiple,String path);

    @Select("select room_name,room_path from Unitroom where location=#{location}")
    List<room_shotcut> getUnitRoom(String location);
    @Select("SELECT room.ID,`NAME`,PATH,room.FIELD,START_TIME,END_TIME,LOCATION FROM room where END_TIME=#{field}")
    room selectByUnitMac(String field);

    @Delete("delete from room where id=#{id}")
    int deleteRoomByID(int id);

    @Select("select version_code from version")
    String getVersion_code();

    @Update("update room set NAME=#{NAME},PATH=#{PATH},FIELD=#{FIELD},START_TIME=#{START_TIME},END_TIME=#{END_TIME},LOCATION=#{LOCATION},RESERVE=#{RESERVE} where NAME=#{orign}")
    boolean modify(modify_to_room_info modifyRoomInfo);

    @Select("select * from room_ad where path=#{path}")
    List<room_ad> get_room_AD_INFO(String path);




}
