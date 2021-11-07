package br.com.santander.pedidos.dto;

public class ItemFormDTO {

	private Long id;
	private int quantidade;

	public ItemFormDTO(Long id, int quantidade) {
		this.id = id;
		this.quantidade = quantidade;
	}

	public Long getProdutoId() {
		return id;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
}
