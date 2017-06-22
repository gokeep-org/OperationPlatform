package com.op.metric;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 度量服务启动文件
 */
@SpringBootApplication
public class MetricBootStrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MetricBootStrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
