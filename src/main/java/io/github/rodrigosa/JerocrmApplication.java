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

            clientes.salvar(new Cliente("Rodrigo"));

            clientes.salvar(new Cliente("Douglas"));

            System.out.println("Buscando todos os clientes: ");

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes: ");

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " Atualizado.");
                clientes.atualizar(c);
            });

            System.out.println("Buscando clientes por nome: ");


            clientes.buscarPorNome("dri").forEach(System.out::println);

            //todosClientes = clientes.obterTodos();
            //todosClientes.forEach(System.out::println);

            System.out.println("Deletando clientes: ");

            clientes.obterTodos().forEach(c->{
                clientes.deletar(c);
            });

            todosClientes = clientes.obterTodos();
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
