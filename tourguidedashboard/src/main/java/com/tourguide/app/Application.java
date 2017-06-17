package com.tourguide.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by manjtsingh on 6/13/2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.tourguide.dashboard"})
public class Application extends SpringBootServletInitializer {
    public static void main(String args[]) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
