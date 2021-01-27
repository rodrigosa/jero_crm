package io.github.rodrigosa.domain.repository;

import io.github.rodrigosa.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
