package com.dtxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class testController {

    @RequestMapping("/roomview")
    public String test()
    {
        return "roomview";
    }

}
