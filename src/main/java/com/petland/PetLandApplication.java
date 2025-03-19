package com.petland;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.petland.repository")
public class PetLandApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetLandApplication.class, args);
    }
}
