package br.com.santander.pedidos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.pedidos.api.CadastroApi;
import br.com.santander.pedidos.api.CatalogoProdutosApi;
import br.com.santander.pedidos.dto.ClienteDTO;
import br.com.santander.pedidos.dto.ItemFormDTO;
import br.com.santander.pedidos.dto.PedidoDTO;
import br.com.santander.pedidos.dto.PedidoFormDTO;
import br.com.santander.pedidos.model.ItemPedido;
import br.com.santander.pedidos.model.Pedido;
import br.com.santander.pedidos.model.Produto;
import br.com.santander.pedidos.services.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

	private final PedidoService service;
	private final CadastroApi cadastroApi;
	private final CatalogoProdutosApi catalogoApi;
	private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);

	@Autowired
	public PedidoController(PedidoService service, CadastroApi cadastroApi, CatalogoProdutosApi catalogoApi) {
		this.service = service;
		this.cadastroApi = cadastroApi;
		this.catalogoApi = catalogoApi;
	}

	@PostMapping
	public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoFormDTO form) {
		LOG.info("Buscando informação do cliente...");
		ClienteDTO cliente = this.cadastroApi.buscarCliente(form.getIdCliente());

		LOG.info("Buscando informação dos produtos...");

//		List<Item> itens = form.getItensFormDTO().stream()
//				.map(item -> new Item(this.catalogoApi.buscarProdutoPorId(item.getProdutoId())))
//				.collect(Collectors.toList());

		final Pedido pedido = new Pedido(cliente.getNome());
		for (ItemFormDTO i : form.getProdutos()) {
			Long id = i.getProdutoId();
			Produto produto = this.catalogoApi.buscarProdutoPorId(id);
			ItemPedido item = new ItemPedido(produto, i.getQuantidade());
			//item.setProduto(produto);
			pedido.adicionaItem(item);
		}
		pedido.setEndereco(form.getEndereco());
		
//		
//		final Pedido pedido = new Pedido(cliente.getNome());
//		for (Item item : itens) {
//			pedido.adicionaItem(item);
//		}
		//itens.forEach(item -> pedido.adicionaItem(item));
		
		Pedido pedidoSalvo = service.salvar(pedido);

		PedidoDTO dto = new PedidoDTO(pedidoSalvo);
		return ResponseEntity.ok(dto);
	}

}
