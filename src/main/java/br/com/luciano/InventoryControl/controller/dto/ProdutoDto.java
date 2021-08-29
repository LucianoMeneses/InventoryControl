package br.com.luciano.InventoryControl.controller.dto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.luciano.InventoryControl.model.Categoria;
import br.com.luciano.InventoryControl.model.Produto;

public class ProdutoDto {
	
	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;

	private LocalDate dataCadastro = LocalDate.now();
	
	private Categoria categoria;
	
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.dataCadastro = produto.getDataCadastro();
		this.categoria = produto.getCategoria();		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public static List<ProdutoDto> converter(List<Produto> produtos){
				
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
		
	}
	

}
