package com.example.demo_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@ResponseBody
//@Controller
@RestController
//@RequestMapping("/view")
public class SecurityDemoController {

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String test(){
        return "index";
    }



    @ResponseBody
    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    public String test1(){
        return "index in body";
    }


}
