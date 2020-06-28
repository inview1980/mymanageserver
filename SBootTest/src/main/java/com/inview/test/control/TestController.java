package com.inview.test.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {
    @GetMapping("/tt")
    public String start() {
        log.info("hello");
        return "hello";

    }

    @GetMapping("ts")
    public Map<String,String> start2(HttpServletRequest request){
        var result = new HashMap<String, String>();
        result.put("a1", "a1");
        result.put("a2","a2");
        request.setAttribute("aaa","aaaa");
        return result;
    }
}
