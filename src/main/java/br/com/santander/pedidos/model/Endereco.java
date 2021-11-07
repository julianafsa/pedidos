package br.com.santander.pedidos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.santander.pedidos.enumerations.TipoEndereco;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private TipoEndereco tipo;
	
	@OneToOne(mappedBy = "endereco")
	private Pedido pedido;

	public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado,
			String cep, TipoEndereco tipo, Pedido pedido) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.tipo = tipo;
		this.pedido = pedido;
	}
	
}
