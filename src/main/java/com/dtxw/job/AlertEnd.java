package com.dtxw.job;

import com.dtxw.model.InMessage;
import com.dtxw.model.Injection;
import com.dtxw.service.ChatService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class AlertEnd implements Job {

    public ChatService chatService = new Injection().getChatService();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        InMessage inMessage = new InMessage("0",jobDataMap.getString("Room_Path"),"Room Closed at"+jobDataMap.getString("End_Time"));
        System.out.println("LALALA");
        chatService.sendMessage(inMessage);
        System.out.println(jobDataMap.getString("Room_Name")+"   IS CLOSED ! AT "+jobDataMap.getString("End_Time"));

    }
}
