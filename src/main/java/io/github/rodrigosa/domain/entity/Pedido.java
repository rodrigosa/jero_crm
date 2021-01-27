package io.github.rodrigosa.domain.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", total=" + total +
                '}';
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
