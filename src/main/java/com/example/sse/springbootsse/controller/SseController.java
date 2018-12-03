package com.example.sse.springbootsse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {

    // 服务器端SSE支持输出媒体类型为text/event-stream
    @RequestMapping(value="/push",produces="text/event-stream")
    public @ResponseBody
    String push(){
        Random r=new Random();
        try{
            //睡眠5秒
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Test"+r.nextInt()+"\n\n";
    }

}
