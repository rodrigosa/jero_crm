package io.github.rodrigosa;

import io.github.rodrigosa.domain.entity.Cliente;
import io.github.rodrigosa.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JerocrmApplication {


    public static void main(String[] args) {
        SpringApplication.run(JerocrmApplication.class, args);
    }




}
