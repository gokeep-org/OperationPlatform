package com.op.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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