package com.op.admin.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-4-21
 ****************************************/
@Controller
public class InfoRest {
    @GetMapping("/")
    public String info(){
        return "it works";
    }
}
