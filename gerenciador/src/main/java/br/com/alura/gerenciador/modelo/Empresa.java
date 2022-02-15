package br.com.alura.gerenciador.modelo;

public class Empresa {
	private Long id;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa(String nome) {
		this.nome = nome;
	}

}
