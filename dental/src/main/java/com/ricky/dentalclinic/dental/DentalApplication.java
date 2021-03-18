package com.ricky.dentalclinic.dental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication(scanBasePackages = "com.ricky.dentalclinic.dental")
public class DentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DentalApplication.class, args);
    }

}
