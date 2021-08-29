package br.com.luciano.InventoryControl.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.luciano.InventoryControl.controller.dto.ProdutoDto;
import br.com.luciano.InventoryControl.controller.form.ProdutoForm;
import br.com.luciano.InventoryControl.model.Produto;
import br.com.luciano.InventoryControl.repository.CategoriaRepository;
import br.com.luciano.InventoryControl.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<ProdutoDto> buscarProdutosNome(String nomeProduto) {

		if (nomeProduto == null || nomeProduto.isEmpty()) {

			List<Produto> produtos = produtoRepository.findAll();
			
			return ProdutoDto.converter(produtos);
		}
		
		List<Produto> produtos = produtoRepository.findByNome(nomeProduto);
		
		return ProdutoDto.converter(produtos);
		
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrarPorduto(@RequestBody ProdutoForm form, UriComponentsBuilder uriBuilder) {
		
		Produto produto = form.converter(categoriaRepository);
		
		produtoRepository.save(produto);
		
		URI uri = uriBuilder.path("produtos/{id}").buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
		
	}


}
