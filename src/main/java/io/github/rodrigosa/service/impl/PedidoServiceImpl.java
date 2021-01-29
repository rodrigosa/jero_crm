package io.github.rodrigosa.service.impl;

import io.github.rodrigosa.domain.repository.Pedidos;
import io.github.rodrigosa.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
