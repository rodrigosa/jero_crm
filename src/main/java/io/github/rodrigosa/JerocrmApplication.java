package io.github.rodrigosa;

import io.github.rodrigosa.domain.entity.Cliente;
import io.github.rodrigosa.domain.entity.Pedido;
import io.github.rodrigosa.domain.repository.Clientes;
import io.github.rodrigosa.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class JerocrmApplication {

    @Bean
    public CommandLineRunner init (
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos){
        return args -> {

            System.out.println("Salvando Clientes: ");

            Cliente rodrigo = new Cliente("Rodrigo");
            clientes.save(rodrigo);


            System.out.println("Inserindo Pedidos: ");
            Pedido p = new Pedido();
            p.setCliente(rodrigo);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

          /*  System.out.println("Buscando clientes com pedidos: ");
            Cliente cliente = clientes.findClienteFetchPedidos(rodrigo.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());

            System.out.println("Deletando clientes: ");*/

            pedidos.findByCliente(rodrigo).forEach(System.out::println);

        };

    }

    public static void main(String[] args) {
        SpringApplication.run(JerocrmApplication.class, args);
    }




}
