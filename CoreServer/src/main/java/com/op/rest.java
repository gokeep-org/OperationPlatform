package com.op;

import org.springframework.web.bind.annotation.*;


/**
 * Created by me on 2017/1/5.
 */
@RestController
@RequestMapping(value = "/test")
public class rest {
    @PostMapping(value = "/test1")
    public String test1(){
        return "Hello world";
    }
}