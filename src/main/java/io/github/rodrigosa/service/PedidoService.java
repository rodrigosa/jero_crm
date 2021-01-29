package io.github.rodrigosa.service;

import io.github.rodrigosa.domain.entity.Pedido;
import io.github.rodrigosa.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
}
