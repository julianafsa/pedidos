package br.com.santander.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteDTO {
	
	private String nome;
	private EnderecoDTO endereco;
	private String telefone;
	
}
