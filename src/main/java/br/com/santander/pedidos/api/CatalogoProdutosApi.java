package br.com.santander.pedidos.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.santander.pedidos.model.Produto;

@FeignClient("catalogoprodutos")
public interface CatalogoProdutosApi {
	
	@GetMapping("/produtos/{id}")
	//public ProdutoDTO buscarProdutoPorId(@PathVariable Long id);
	public Produto buscarProdutoPorId(@PathVariable Long id);
	
}
