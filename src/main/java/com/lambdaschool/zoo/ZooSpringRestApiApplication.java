package com.lambdaschool.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ZooSpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooSpringRestApiApplication.class, args);
    }

}
