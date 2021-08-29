package br.com.luciano.InventoryControl.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.luciano.InventoryControl.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByNome(String nomeProduto);

	List<Produto> findByCategoriaNome(String nomeCategoria);

}
