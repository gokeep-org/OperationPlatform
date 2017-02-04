package com.op;

import com.op.config.JerseyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JerseyConfig.class)
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
