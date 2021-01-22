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

            System.out.println("Salvando Clientes: ");

            clientes.save(new Cliente("Rodrigo"));

            clientes.save(new Cliente("Douglas"));

            System.out.println("Buscando todos os clientes: ");

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes: ");

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " Atualizado.");
                clientes.save(c);
            });

            System.out.println("Buscando clientes por nome: ");


            clientes.findByNomeLike("%dri%").forEach(System.out::println);

            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Deletando clientes: ");

            clientes.findAll().forEach(c->{
                clientes.delete(c);
            });

            System.out.println("Exibindo Clientes da base: ");

            todosClientes = clientes.findAll();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado!!");
            }else{
                todosClientes.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(JerocrmApplication.class, args);
    }




}
