package com.dtxw.service;

import com.dtxw.entity.Reserve;
import com.dtxw.entity.Reserve_Multiple;
import com.dtxw.entity.room;
import com.dtxw.mapper.RoomMapper;
import com.dtxw.model.AddRoomInfo;
import com.dtxw.model.ModifyRoomInfo;
import com.dtxw.model.modify_to_room_info;
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

    public boolean modifyRoom(ModifyRoomInfo modifyRoomInfo)
    {
        String orignal_name = modifyRoomInfo.getOrign();
        String new_name = modifyRoomInfo.getName();
        if (orignal_name.equals(new_name))
        {
            roomMapper.modify(new modify_to_room_info(modifyRoomInfo));
            return true;
        }
        else
        {
            room r = roomMapper.getRoomByName(new_name);
            if (null==r)
            {
                roomMapper.modify(new modify_to_room_info(modifyRoomInfo));
                return true;
            }
            else
                return false;
        }

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
