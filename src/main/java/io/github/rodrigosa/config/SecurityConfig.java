package io.github.rodrigosa.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Traz os objetos que vão fazer a autenticação dos usuários e adicionar estes usuários dentro do contexto
     * do security
     * @param auth
     * @throws Exception
     */

    //Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    //Autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
