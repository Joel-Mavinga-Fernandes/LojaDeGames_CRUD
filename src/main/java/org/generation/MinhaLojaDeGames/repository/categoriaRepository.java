package org.generation.MinhaLojaDeGames.repository;

import java.util.List;

import org.generation.MinhaLojaDeGames.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriaRepository extends JpaRepository <Categoria, Long>{
	
	public List<Categoria> findAllByNomeCategoriaContainigIgnoreCase(String nomeCategoria);

}
