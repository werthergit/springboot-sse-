package com.example.sse.springbootsse.controller;


import com.example.sse.springbootsse.TaskExecutorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@Controller
public class SseEmitterController {

    @Autowired
    TaskExecutorConfiguration taskExecutorConfiguration;

    @RequestMapping(value="/push2",produces="text/event-stream")
    public @ResponseBody
    SseEmitter push(){
        //timeout设置为0表示不超时
        final SseEmitter emitter = new SseEmitter(0L);
        taskExecutorConfiguration.getAsyncExecutor().execute(() -> {
            try {
                for(int i=0;i<100;i++){
                    emitter.send("中文测试：hello"+i);
                    System.out.println("emit:"+i+" hello");
                    Thread.sleep(1000*1);
                }
                emitter.complete();
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        });
        return emitter;
    }
}
