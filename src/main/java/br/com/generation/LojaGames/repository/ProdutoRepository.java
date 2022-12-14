package br.com.generation.LojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.generation.LojaGames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto>findByNomeContainingIgnoreCase(@Param("nome")String nome);
}
