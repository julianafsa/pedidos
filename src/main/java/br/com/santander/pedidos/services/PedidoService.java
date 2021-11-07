package br.com.santander.pedidos.services;

import org.springframework.stereotype.Service;

import br.com.santander.pedidos.model.Pedido;
import br.com.santander.pedidos.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	private final PedidoRepository repository;

	public PedidoService(PedidoRepository repository) {
		this.repository = repository;
	}
	
	public Pedido salvar(Pedido pedido) {
		return repository.save(pedido);
	}
	
}
