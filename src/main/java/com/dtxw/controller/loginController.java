package com.dtxw.controller;

import com.dtxw.entity.Fieldtomac;
import com.dtxw.entity.Locationtofield;
import com.dtxw.job.AlertEnd;
import com.dtxw.mapper.LocationMapper;
import com.dtxw.mapper.RoomManagerMapper;
import com.dtxw.model.AddRoomInfo;
import com.dtxw.model.LoginInfo;
import com.dtxw.service.RoomService;
import com.dtxw.service.TimeService;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


@Controller
public class loginController {

    @Autowired
    RoomManagerMapper roomManagerMapper;
    @Autowired
    RoomService roomService;
    @Autowired
    LocationMapper locationMapper;

//    @RequestMapping(value = "/login" , method = RequestMethod.POST)
//    public String ManagerLogin(@RequestParam(value = "password") String password, @RequestParam(value = "name")String name, HttpSession httpSession)
//    {
//        RoomManager roomManager = roomManagerMapper.getRoomManagerByName(name);
//        if(roomManager.getPassword().equals(password))
//        {
//            return "ChatPage";
//        }
//        else
//        {
//            return "hello";
//        }
//    }
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String ManagerLogin(@ModelAttribute LoginInfo loginInfo, Model model)
    {
        System.out.println(loginInfo.getID()+loginInfo.getPSW());

        model.addAttribute("loginInfo",loginInfo);
        if(roomManagerMapper.getRoomManagerByName(loginInfo.getID()).getPassword().equals(loginInfo.getPSW()))
        {

            return "manage/backgroundSystem";
        }
        else
        {
            loginInfo.setID("Login Error!");
            return "manage/login";
        }
    }



    @RequestMapping(value = "/addChatRoom",method = RequestMethod.POST)
    public String AddChatRoom(@ModelAttribute AddRoomInfo addRoomInfo,Model model) throws ParseException, SchedulerException {
        int index = locationMapper.getAll().size()+1;
        String t = addRoomInfo.getField();
        String fieldGroup = t.substring(0,t.length()-1);
        if (!fieldGroup.contains(","))
        {
            String s = addRoomInfo.getField();
            addRoomInfo.setField(s.substring(0,s.length()-1));
            s = addRoomInfo.getLocation();
            addRoomInfo.setLocation(s.substring(0,s.length()-1));
            roomService.addRoom(addRoomInfo);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dateFormat.parse(addRoomInfo.getE_time());
            Trigger trigger =newTrigger().startAt(date).build();
            JobDetail job = newJob().ofType(AlertEnd.class).build();
            JobDataMap jobDataMap = job.getJobDataMap();
            jobDataMap.put("Room_Path","/"+addRoomInfo.getName().hashCode());
            jobDataMap.put("End_Time",addRoomInfo.getE_time());
            jobDataMap.put("Room_Name",addRoomInfo.getName());
            TimeService.scheduler.start();
            TimeService.scheduler.scheduleJob(job,trigger);

        }
        else
        {

            String fg[] = fieldGroup.split(",");
            for(int i=0;i<fg.length;i++)
            {
                if(fg[i]!=null)
                {
                    List<Fieldtomac> list = locationMapper.selectFieldtomacById(Integer.parseInt(fg[i]));
                    for(int j=0;j<list.size();j++)
                    {
                        locationMapper.addMAC(new Fieldtomac(list.get(j).getMac(),index));
                    }

                }
            }
            locationMapper.addLocation(new Locationtofield(addRoomInfo.getLocation(),index));
            addRoomInfo.setField(String.valueOf(index));
            roomService.addRoom(addRoomInfo);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dateFormat.parse(addRoomInfo.getE_time());
            Trigger trigger =newTrigger().startAt(date).build();
            JobDetail job = newJob().ofType(AlertEnd.class).build();
            JobDataMap jobDataMap = job.getJobDataMap();
            jobDataMap.put("Room_Path",addRoomInfo.getName().hashCode());
            jobDataMap.put("End_Time",addRoomInfo.getE_time());
            jobDataMap.put("Room_Name",addRoomInfo.getName());
            TimeService.scheduler.scheduleJob(job,trigger);
        }


        model.addAttribute("addRoomInfo",new AddRoomInfo());
        System.out.println(addRoomInfo.getName());
        System.out.println(addRoomInfo.getLocation());
        return "manage/addRoom";
    }
}
