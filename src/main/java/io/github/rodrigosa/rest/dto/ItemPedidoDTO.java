package io.github.rodrigosa.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Integer produto;
    private Integer quantidade;
}
