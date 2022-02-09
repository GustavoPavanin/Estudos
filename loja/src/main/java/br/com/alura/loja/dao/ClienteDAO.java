package br.com.alura.loja.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Pedido;

public class ClienteDAO {
	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Cliente produto) {
		this.em.persist(produto);
	}

	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
}
