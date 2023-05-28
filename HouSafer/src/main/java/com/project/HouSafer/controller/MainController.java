package com.project.HouSafer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping(value = {"/","/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/fraudCases", method = {RequestMethod.GET, RequestMethod.POST})
    public String fraudCases(){
        return "fraudCases";
    }
}
