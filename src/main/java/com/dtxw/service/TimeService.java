package com.dtxw.service;

import com.dtxw.job.AlertEnd;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.dtxw.dataCache.endTime.timer;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Service
public class TimeService {
    @Autowired
    ChatService chatService;
    public static Scheduler scheduler;
    public void INITIAL_runTimer() throws SchedulerException, ParseException {
        scheduler = StdSchedulerFactory.getDefaultScheduler();
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date date = df2.parse(timer.get(0).getEND_TIME());
//        Trigger trigger = newTrigger().withIdentity("1","test").startAt(date).build();

//        JobDetail job = newJob().ofType(AlertEnd.class).build();
//        JobDataMap jobDataMap = job.getJobDataMap();
//        jobDataMap.put("Room_Path",timer.get(0).getPATH());
//        jobDataMap.put("End_Time",timer.get(0).getEND_TIME());
//        jobDataMap.put("Room_Name",timer.get(0).getNAME());
//        scheduler.start();
//        scheduler.scheduleJob(job,trigger);
        for (int i = 0;i< timer.size();i++)
        {
            Date date = df2.parse(timer.get(i).getEND_TIME());
            Trigger trigger = newTrigger().withIdentity(String.valueOf(timer.get(i).getID()),"Room Closer").startAt(date).build();
            JobDetail job = newJob().ofType(AlertEnd.class).build();
            JobDataMap jobDataMap = job.getJobDataMap();
            jobDataMap.put("Room_Path",timer.get(i).getPATH());
            jobDataMap.put("End_Time",timer.get(i).getEND_TIME());
            jobDataMap.put("Room_Name",timer.get(i).getNAME());
            scheduler.start();
            scheduler.scheduleJob(job,trigger);
            System.out.println("No."+i);

        }

        timer.clear();
    }
}
