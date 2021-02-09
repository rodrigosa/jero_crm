package io.github.rodrigosa.config;

import io.github.rodrigosa.security.jwt.JwtAuthFilter;
import io.github.rodrigosa.security.jwt.JwtService;
import io.github.rodrigosa.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private JwtService jwtService;

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

    @Bean
    public OncePerRequestFilter jwtFilter() {

        return new JwtAuthFilter(jwtService, usuarioService);

    }

    //Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder());
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
                .antMatchers(HttpMethod.POST, "/api/usuarios/**")
                .permitAll()
                .anyRequest().authenticated()//Caso esqueça de mapear outra URL
                .and() //Volta para o primeiro metodo
                //.formLogin(); //Aula 69 - 8:50
                //.httpBasic(); //Aula 71
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
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
