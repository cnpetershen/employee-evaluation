package com.peter.smartmedicalserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"com.peter.smartmedicalserver"})
public class SmartMedicalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartMedicalServerApplication.class, args);
    }
}
