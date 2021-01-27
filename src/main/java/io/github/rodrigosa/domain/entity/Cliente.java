package io.github.rodrigosa.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    /**
     *  A propriedade fetch do anotation @OneToMany indica como o objeto será trazido na hora da consulta
     *  FetchType.EAGER -> Traz a lista de clientes junto durante a consulta;
     *  FetchType.LAZY -> Traz somente os Id's dos pedidos
     */

    @OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY) // Um Cliente para vários pedidos. O mapped by é o nome da propriedade cliente que esta mapeada em pedidos
    private Set<Pedido> pedidos; // SET porque um pedido não pode ser repetido

    public Cliente(){

    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
