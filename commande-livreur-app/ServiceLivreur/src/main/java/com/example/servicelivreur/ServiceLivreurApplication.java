package com.example.servicelivreur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceLivreurApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceLivreurApplication.class, args);
    }

}
