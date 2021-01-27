package io.github.rodrigosa.rest.controller;

import io.github.rodrigosa.domain.entity.Cliente;
import io.github.rodrigosa.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @ResponseBody
    @GetMapping("/api/clientes/{id}")
    public ResponseEntity getClienteById(@PathVariable Integer id) {

        Optional<Cliente> cliente = clientes.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }
}
