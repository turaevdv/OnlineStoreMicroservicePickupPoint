package ru.turaev.pickuppoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PickupPointApplication {
    public static void main(String[] args) {
        SpringApplication.run(PickupPointApplication.class, args);
    }
}
