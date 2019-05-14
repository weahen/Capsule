package com.dtxw;

import com.dtxw.dataCache.endTime;
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
        try {
            timeService.INITIAL_runTimer();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
