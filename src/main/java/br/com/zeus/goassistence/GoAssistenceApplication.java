package br.com.zeus.goassistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
public class GoAssistenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoAssistenceApplication.class, args);
    }

}
