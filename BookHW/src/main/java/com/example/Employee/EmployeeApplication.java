package com.example.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

//source: https://stackoverflow.com/questions/38516644/how-to-create-or-configure-rest-template-using-bean-in-spring-boot
@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.Employee.EmployeeApplication.class, args);
    }
    @Bean(name = "restTemplate")
    public RestTemplate getRestClient() {
        return new RestTemplate();
    }
}