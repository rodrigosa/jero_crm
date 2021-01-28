package io.github.rodrigosa.rest.controller;

import io.github.rodrigosa.domain.entity.Cliente;
import io.github.rodrigosa.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente) { // @RequestBody -> diz que o parametro vem no corpo da requsicao

        Cliente clienteSalvo = clientes.save(cliente);

        return ResponseEntity.ok(clienteSalvo);

    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id) {

        Optional<Cliente> cliente = clientes.findById(id);

        if (cliente.isPresent()) {

            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/api/clientes/{id}")// Aula 39
    @ResponseBody //Saída
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente) {

        return clientes
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build()); // OrelseGet recebe um Suplyer como parametro. Suplyer é uma interface fincional que tem um metodo que recebe um parametro e retorna qualquer coisa
    }

    @GetMapping("/api/clientes") // Aula 40
    public ResponseEntity find(Cliente filtro){

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);

        List<Cliente> lista = clientes.findAll(example);

        return ResponseEntity.ok(lista);

    }
}
