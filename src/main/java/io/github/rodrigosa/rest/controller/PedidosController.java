package io.github.rodrigosa.rest.controller;


import io.github.rodrigosa.domain.entity.Pedido;
import io.github.rodrigosa.rest.dto.PedidoDTO;
import io.github.rodrigosa.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private PedidoService service;

    public PedidosController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto) {

        Pedido pedido = service.salvar(dto);

        return pedido.getId();

    }
}
