package com.example.sse.springbootsse.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/s")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
}
