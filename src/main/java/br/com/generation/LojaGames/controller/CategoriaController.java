package br.com.generation.LojaGames.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.generation.LojaGames.model.Categoria;
import br.com.generation.LojaGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@Valid @PathVariable long id){
		return categoriaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping ("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> getByDescricao (@Valid @PathVariable String descricao){
		return ResponseEntity.ok(categoriaRepository.findByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.ok(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}
}
