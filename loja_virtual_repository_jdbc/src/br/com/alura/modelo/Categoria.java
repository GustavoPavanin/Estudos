package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("A categoria é %s ", this.nome);
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
