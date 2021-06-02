package org.generation.MinhaLojaDeGames.controller;

import java.util.List;

import org.generation.MinhaLojaDeGames.model.Produtos;
import org.generation.MinhaLojaDeGames.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository Repository;
	//private Produtos produtos;
	
	@GetMapping
	public ResponseEntity<List<Produtos>>GetAll(){
		return ResponseEntity.ok(Repository.findAll());
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> GetById(@PathVariable long id){
		return Repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome{nome}")
	public ResponseEntity<List<Produtos>> GetByNome(@PathVariable String nome){
		return  ResponseEntity.ok(Repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Produtos> post (@RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(Repository.save(produtos));
	}

	@PutMapping
	public ResponseEntity<Produtos> put (@RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.OK).body(Repository.save(produtos));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		Repository.deleteById(id);
	}
}
	
	