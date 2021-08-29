package br.com.luciano.InventoryControl.controller.form;

import java.math.BigDecimal;

import br.com.luciano.InventoryControl.model.Categoria;
import br.com.luciano.InventoryControl.model.Produto;
import br.com.luciano.InventoryControl.repository.CategoriaRepository;

public class ProdutoForm {
	
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Long idCategoria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Produto converter(CategoriaRepository categoriaRepository) {
		
		Categoria categoria = categoriaRepository.findByIdCategoria(idCategoria);
		
		return new Produto(nome, descricao, preco, categoria);
	}
	
	
}
