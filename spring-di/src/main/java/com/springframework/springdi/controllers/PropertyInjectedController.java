package com.springframework.springdi.controllers;

import com.springframework.springdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    public GreetingService greetingService;

    public  String getGreeting(){
        return greetingService.sayGreeting();
    }
}
