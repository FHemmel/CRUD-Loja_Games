package br.com.generation.LojaGames.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;
	
	@NotBlank (message = "A descrição não pode ficar vazia!")
	@Size(min = 3, max = 255, message = "Descrição deve ter entre 3 e 255 caracteres!")
	private String descricao;
	
	@NotBlank (message = "A descrição do jogo não pode ficar vazia!")
	@Size(min = 3, max = 255, message = "Descrição deve ter entre 3 e 255 caracteres!")
	private String tipo;
	
	//@OneToMany
	//private List<Produto>produto;

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
		
}