package com.op.metric.metric;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/20.
 ****************************************/
public interface Example {
    public default String out(){
        return "is output";
    }
}

class test implements Example{
    public static void main(String[] args) {
        test t= new test();

        System.out.println(t.out());
    }
}
