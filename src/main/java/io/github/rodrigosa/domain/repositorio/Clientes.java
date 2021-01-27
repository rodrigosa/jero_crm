package io.github.rodrigosa.domain.repositorio;

import io.github.rodrigosa.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {


    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String nome);
}
