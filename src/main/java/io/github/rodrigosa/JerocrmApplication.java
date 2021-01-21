package io.github.rodrigosa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JerocrmApplication {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(JerocrmApplication.class, args);
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName;
    }

}
