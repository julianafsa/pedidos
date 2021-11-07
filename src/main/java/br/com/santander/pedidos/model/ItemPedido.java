package br.com.santander.pedidos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class ItemPedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "preco")
	private BigDecimal valor;
	private String nome;
	private int quantidade = 0;
	
	@Setter
	@ManyToOne
	@JoinColumn(name = "produto_fk")
	private Produto produto;
	
	@Setter
	@ManyToOne
	@JoinColumn(name = "pedido_fk")
	@JsonIgnore
	private Pedido pedido;
	
	@Transient
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public ItemPedido(Produto produto, int quantidade) {
		this.valor = produto.getPreco();
		//this.produto = produto;
		this.nome = produto.getNome();
		this.quantidade = quantidade;
		this.valorTotal = valor.multiply(BigDecimal.valueOf(quantidade));
	}
	
//	public ItemPedido(ProdutoDTO produto, int quantidade) {
//		this.valor = produto.getPreco();
//		this.nome = produto.getNome();
//		this.quantidade = quantidade;
//		this.valorTotal = valor.multiply(BigDecimal.valueOf(quantidade));
//	}
	
}
