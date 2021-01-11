package com.hcl.ecommerce1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com")
@EntityScan(basePackages = "com")
@ComponentScan("com")
public class Ecommerce1Application {
    public static void main(String[] args) {
        SpringApplication.run(Ecommerce1Application.class, args);
    }

}