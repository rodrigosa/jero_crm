package io.github.rodrigosa.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data //Já possui Getter and Setters
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "O campo nome é obrigatório!")
    private String nome;


    @Column(name = "cpf", length = 11)
    private String cpf;

    /**
     * A propriedade fetch do anotation @OneToMany indica como o objeto será trazido na hora da consulta
     * FetchType.EAGER -> Traz a lista de clientes junto durante a consulta;
     * FetchType.LAZY -> Traz somente os Id's dos pedidos
     */

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    // Um Cliente para vários pedidos. O mapped by é o nome da propriedade cliente que esta mapeada em pedidos
    private Set<Pedido> pedidos; // SET porque um pedido não pode ser repetido


    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
