package br.com.luciano.InventoryControl.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.luciano.InventoryControl.model.Categoria;

public class CategoriaDto {
	
	private Long id;
	
	private String nome;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getName();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	

	public static List<CategoriaDto> converter(List<Categoria> categorias) {
				
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}

}
