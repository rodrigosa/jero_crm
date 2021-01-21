package io.github.rodrigosa;

import io.github.rodrigosa.domain.entity.Cliente;
import io.github.rodrigosa.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JerocrmApplication {

    @Bean
    public CommandLineRunner init (@Autowired Clientes clientes){
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Rodrigo");
            clientes.salvar(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(JerocrmApplication.class, args);
    }




}
