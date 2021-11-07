package br.com.santander.pedidos.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.santander.pedidos.dto.ClienteDTO;

@FeignClient("cadastro")
public interface CadastroApi {
	
	@GetMapping("/clientes/{id}")
	public ClienteDTO buscarCliente(@PathVariable Long id);
	
}
