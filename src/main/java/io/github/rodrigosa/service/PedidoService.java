package io.github.rodrigosa.service;

import io.github.rodrigosa.domain.entity.Pedido;
import io.github.rodrigosa.domain.enums.StatusPedido;
import io.github.rodrigosa.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
