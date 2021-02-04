package io.github.rodrigosa;

import io.github.rodrigosa.domain.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value(("${seurity.jwt.expiracao}"))
    private String expiracao;

    @Value(("${seurity.jwt.chave-assinatura}"))
    private String chaveAssinatura;

    public String geraToken(Usuario usuario) {
        long expString = Long.valueOf(expiracao);

        //pego a data e hora atual e somo mais minutos, no caso 30
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);

        //Convertendo localDateTyme para Date
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(usuario.getLogin())//Parte do payload
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)//Assinatura do token
                .compact();
    }

    public static void main(String[] args){
        ConfigurableApplicationContext contexto = SpringApplication.run(JerocrmApplication.class);//Carregando  contexto para injetar as propriedades
        JwtService service  = contexto.getBean(JwtService.class);
        Usuario usuario = Usuario.builder().login("fulano").build();
        String token = service.geraToken(usuario);
        System.out.println(token);
    }
}
