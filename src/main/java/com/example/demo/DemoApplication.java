package com.example.demo;

import com.example.demo.dto.LinkDto;
import com.example.demo.dto.MetricsDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static Map<Integer, LinkDto> staticDb = new HashMap<>();
    public static Map<Integer, MetricsDto> staticMetrics = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}