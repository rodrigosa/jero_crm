package io.github.rodrigosa.domain.repository;

import io.github.rodrigosa.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {


    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String nome);

    /**
     * Na JPQL usando somente o join ele me traria os clientes somente se existisse pedidos
     * com o left join traz os clientes mesmo se nao tiverem pedidos
     * @param id
     * @return
     */

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);


}
