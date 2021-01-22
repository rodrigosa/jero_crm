package io.github.rodrigosa.domain.repositorio;

import io.github.rodrigosa.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class Clientes {


    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente) {

        entityManager.persist(cliente);
        return cliente;

    }

    @Transactional(readOnly = true)
    public List<Cliente> obterTodos() {
        return entityManager
                .createQuery("from Cliente", Cliente.class)
                .getResultList();
    }


    @Transactional
    public Cliente atualizar(Cliente cliente) {
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente) {

        if (!entityManager.contains(cliente)) {

            cliente = entityManager.merge(cliente);

        }
        entityManager.remove(cliente);

    }

    @Transactional
    public void deletar(Integer id) {

        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome) {

        String jpql = " select c from Cliente c where c.nome like :nome "; //:parametro em JPA, e o objeto Clientes tem que ser o nome da classe case sensitive
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class); //TypedQuery retorna a query tipada
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();

    }


}
