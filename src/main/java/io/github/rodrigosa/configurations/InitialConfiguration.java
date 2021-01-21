package io.github.rodrigosa.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@Development
public class InitialConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO!");
        };
    }
}
