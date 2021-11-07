package br.com.santander.pedidos.dto;

import br.com.santander.pedidos.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnderecoDTO {
	
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String tipo;
	
	public EnderecoDTO(Endereco endereco) {
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
		this.tipo = endereco.getTipo().toString();
	}
	
}
