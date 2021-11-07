package br.com.santander.pedidos.dto;

import java.math.BigDecimal;

import br.com.santander.pedidos.model.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemDTO {
	
	private String nome;
	private BigDecimal valor;
	private int quantidade;
	
	public ItemDTO(ItemPedido item) {
		this.nome = item.getNome();
		this.valor = item.getValor();
		this.quantidade = item.getQuantidade();
	}

}
