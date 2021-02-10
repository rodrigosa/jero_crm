package io.github.rodrigosa.domain.entity;

import io.github.rodrigosa.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne // Muitos pedidos (nome da Entidade) para um Cliente
    @JoinColumn(name = "cliente_id") // Nome da coluna/foeign key na tanela pedido
    private Cliente cliente;


    @Column(name = "data_pedido")
    private LocalDate dataPedido; // Recomendado utilizar LocalDate porque é mais simples trabalhar com esse tipo

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    @Column(name = "total", precision = 20, scale = 2) // BigDecimal 20,2 na tabela
    private BigDecimal total;

    @Enumerated(EnumType.STRING) //Anotation para gravar a String n abase
    @Column(name = "status")
    private StatusPedido status;


}
