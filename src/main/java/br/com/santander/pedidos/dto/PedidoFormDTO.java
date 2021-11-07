package br.com.santander.pedidos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.santander.pedidos.model.Endereco;
import br.com.santander.pedidos.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PedidoFormDTO {
	
	private Long idCliente;
	private Endereco endereco;
	private List<ItemFormDTO> produtos = new ArrayList<>();
	
	public Pedido converte(String nome, BigDecimal valorTotal) {
		Pedido pedido = new Pedido(nome, valorTotal);
		return pedido;
	}

}
