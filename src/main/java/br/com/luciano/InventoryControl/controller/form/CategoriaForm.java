package br.com.luciano.InventoryControl.controller.form;

import br.com.luciano.InventoryControl.model.Categoria;

public class CategoriaForm {

	private Long id;
	
	private String nome;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria converter() {
		
		return new Categoria(id, nome);
	}
}
