package com.dtxw.service;

import com.dtxw.entity.Reserve_Multiple;
import com.dtxw.entity.room;
import com.dtxw.mapper.RoomMapper;
import com.dtxw.model.AddRoomInfo;
import com.dtxw.entity.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    RoomMapper roomMapper;

    public boolean addRoom(AddRoomInfo addRoomInfo)
    {
        room r = roomMapper.getRoomByName(addRoomInfo.getName());
        if(r==null)
        {
            roomMapper.addRoom(new room(addRoomInfo));
            return true;
        }
        else
            return false;
    }

    public void addReserve(Reserve reserveInfo)
    {
        roomMapper.addReserve(reserveInfo);
    }

    public void addMultipleReserve(Reserve_Multiple multiple)
    {
        roomMapper.addMultipleReserve(multiple);
    }

}
