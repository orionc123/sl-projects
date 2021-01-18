package com.hcl.phase3end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
public class Phase3endApplication {
    public static void main(String[] args) {
        SpringApplication.run(Phase3endApplication.class, args);
    }

}
