package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@EmbeddedId
	private CategoriaId categoriaid;
	
	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.categoriaid = new CategoriaId(nome, "XPTO");
	}

	public String getNome() {
		return this.categoriaid.getNome();
	}

	public void setNome(String nome) {
		this.categoriaid.setNome(nome);
	}

}
