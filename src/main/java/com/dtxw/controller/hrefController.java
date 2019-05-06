package com.dtxw.controller;

import com.dtxw.model.AccessField;
import com.dtxw.model.RegistInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hrefController {
    @RequestMapping("/regist")
    public String Regist(Model model)
    {
        model.addAttribute("registInfo",new RegistInfo());
        return "manage/register";
    }

    @RequestMapping("/audit")
    public String audit(Model model)
    {
        model.addAttribute("access",new AccessField());
        return "manage/updateRoom";
    }
}
