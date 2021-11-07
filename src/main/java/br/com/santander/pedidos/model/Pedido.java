package br.com.santander.pedidos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime data = LocalDateTime.now();
	private String nomeCliente;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Pedido(String nomeCliente, BigDecimal valorTotal) {
		this.nomeCliente = nomeCliente;
		this.valorTotal = valorTotal;
	}
	
	public List<ItemPedido> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	public void adicionaItem(ItemPedido item) {
		this.valorTotal = this.valorTotal.add(item.getValorTotal());
		item.setPedido(this);
		this.itens.add(item);
	}
	
}
