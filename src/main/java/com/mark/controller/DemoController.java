package com.mark.controller;

import com.mark.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mark on 2017/9/2.
 */
@RestController
public class DemoController {

    private final TestService testService;

    @Autowired
    public DemoController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/test")
    public String test() {
//        throw new RuntimeException("你好 exception");
        testService.exeService();
        ;
        return "date be execute successful!";
    }
}
