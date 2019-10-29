package com.dtxw;

import com.dtxw.dataCache.endTime;
import com.dtxw.dataCache.onLine_User;
import com.dtxw.mapper.RoomMapper;
import com.dtxw.service.TimeService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class AfterRun implements CommandLineRunner {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    TimeService timeService;



    @Override
    public void run(String... args) {
        endTime.timer = roomMapper.getEndTime();
        for (int i=0;i<endTime.timer.size();i++)
            onLine_User.path_count.put("/chat"+endTime.timer.get(i).getPATH(),0);
        try {
            timeService.INITIAL_runTimer();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
