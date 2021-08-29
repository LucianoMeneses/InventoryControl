package br.com.luciano.InventoryControl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.luciano.InventoryControl.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNome(String nome);

	@Query("select c from Categoria c where cat_name = UPPER(:nomeCategoria)")
	List<Categoria> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

	Categoria findByNome(Categoria categoria);

	@Query("select c from Categoria c where cat_id = :idCategoria")
	Categoria findByIdCategoria(@Param("idCategoria") Long idCategoria);
	

}
