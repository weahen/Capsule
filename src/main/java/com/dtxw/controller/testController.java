package com.dtxw.controller;

import com.dtxw.dataCache.endTime;
import com.dtxw.entity.room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class testController {

    @RequestMapping("/roomview")
    public String test()
    {
        return "roomview";
    }

    @RequestMapping("/testEndTime")
    @ResponseBody
    public List<room> getEndTime()
    {
        return endTime.timer;
    }

}
