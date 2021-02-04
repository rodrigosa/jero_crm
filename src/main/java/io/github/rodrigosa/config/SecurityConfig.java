package io.github.rodrigosa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Traz os objetos que vão fazer a autenticação dos usuários e adicionar estes usuários dentro do contexto
     * do security
     *
     * @throws Exception
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //Algoritimo de autenticação
    }

    //Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("fulano")
                .password(passwordEncoder().encode("123"))
                .roles("USER", "ADMIN");
    }

    //Autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//desabilitando segurança entre frontend e backend STATELESS
                .authorizeRequests()
                .antMatchers("/api/clientes/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/pedidos/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/produtos/**")
                .hasRole("ADMIN")
                .and() //Volta para o primeiro metodo
                //.formLogin(); //Aula 69 - 8:50
                .httpBasic(); //Aula 71
        ;
    }
    /**
     * <form method="post">
     *     <input type="text" name="username"
     *     <input type="secret" name="password"
     *      <button type="submit"...
     * </form>
     *
     * .formLogin("/meu-login.html"); //Aula 69 - 8:50
     */
}
