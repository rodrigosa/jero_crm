package io.github.rodrigosa.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Jero_CRM";

    }
}
