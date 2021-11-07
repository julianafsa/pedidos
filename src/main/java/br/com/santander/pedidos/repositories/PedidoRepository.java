package br.com.santander.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
