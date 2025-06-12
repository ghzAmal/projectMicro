package com.example.servicecommande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCommandeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCommandeApplication.class, args);
    }

}
