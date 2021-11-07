package br.com.santander.pedidos.dto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.santander.pedidos.model.Pedido;
import lombok.Getter;

@Getter
public class PedidoDTO {
	
	//@JsonProperty("Número")
	private Long id;
	private String nomeCliente;
	private LocalDateTime data;
	private EnderecoDTO endereco;
	private List<ItemDTO> itens;
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.nomeCliente = pedido.getNomeCliente();
		this.data = pedido.getData();
		this.endereco = new EnderecoDTO(pedido.getEndereco());
		this.itens = pedido.getItens().stream().map(ItemDTO::new).collect(Collectors.toList());
	}

	public List<ItemDTO> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
}
