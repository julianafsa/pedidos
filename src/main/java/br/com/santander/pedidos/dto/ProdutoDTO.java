package br.com.santander.pedidos.dto;

import java.math.BigDecimal;

import br.com.santander.pedidos.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProdutoDTO {
	
	private String nome;
	private String descricao;
	private BigDecimal preco;
	
	public ProdutoDTO(Produto produto) {
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
	}

	public ProdutoDTO(ProdutoDTO produto) {
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
	}
	
}
