package com.example.week9;

import com.example.week9.rabbitconfig.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RabbitConfig.class)
public class Week9Application {

    public static void main(String[] args) {
        SpringApplication.run(Week9Application.class, args);
    }

}
