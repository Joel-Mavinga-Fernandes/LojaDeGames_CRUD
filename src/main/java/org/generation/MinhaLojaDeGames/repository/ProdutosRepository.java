package org.generation.MinhaLojaDeGames.repository;

import java.util.List;

import org.generation.MinhaLojaDeGames.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutosRepository extends JpaRepository <Produtos, Long> {
	
	public List<Produtos> findAllByNomeContainingIgnoreCase(String nome);

}
