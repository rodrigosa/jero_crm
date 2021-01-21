package io.github.rodrigosa;

import io.github.rodrigosa.domain.entity.Cliente;
import io.github.rodrigosa.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JerocrmApplication {

    @Bean
    public CommandLineRunner init (@Autowired Clientes clientes){
        return args -> {
            clientes.salvar(new Cliente("Rodrigo"));

            clientes.salvar(new Cliente("Douglas"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(JerocrmApplication.class, args);
    }




}
