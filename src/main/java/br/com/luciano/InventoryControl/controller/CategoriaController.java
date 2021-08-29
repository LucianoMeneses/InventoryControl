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

import br.com.luciano.InventoryControl.controller.dto.CategoriaDto;
import br.com.luciano.InventoryControl.controller.form.CategoriaForm;
import br.com.luciano.InventoryControl.model.Categoria;
import br.com.luciano.InventoryControl.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<CategoriaDto> buscarCategoriaNome(String nomeCategoria) {
		
		if(nomeCategoria == null || nomeCategoria.isEmpty()) {
			
			List<Categoria> categorias = categoriaRepository.findAll();
			
			return CategoriaDto.converter(categorias);
			
		}
		
			List<Categoria> categorias = categoriaRepository.findByNomeCategoria(nomeCategoria);
		
			return CategoriaDto.converter(categorias);
		
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDto> cadastrarCategoria(@RequestBody CategoriaForm form, UriComponentsBuilder uriBuilder) {
		
		Categoria categoria = form.converter();
		
		categoriaRepository.save(categoria);
		
		URI uri = uriBuilder.path("categorias/{id}").buildAndExpand(categoria.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
		
	}
}
