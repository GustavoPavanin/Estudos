package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		//cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);
		Produto p = pdao.buscarPorId(1L);
		System.out.println(p.getPreco());
		
		List<Produto> produtos = pdao.buscarPorNomeDaCategoria("Instrumentos");
		produtos.forEach(prod -> System.out.println(prod.getId() + " | " + prod.getNome() + " | " + prod.getPreco()));
		
		BigDecimal precoDoProduto = pdao.buscarPrecoDoPorNome("Banjo 5 cordas");
		System.out.println("Preço do Produto: " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria categoria = new Categoria("Instrumentos");
		Produto produto = new Produto("Banjo 5 cordas", "Banjo Bluegrass", new BigDecimal("2000"), categoria );
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);
		CategoriaDAO cdao = new CategoriaDAO(em);
		em.getTransaction().begin();
		cdao.cadastrar(categoria);	
		pdao.cadastrar(produto);
		em.getTransaction().commit();
		em.close();
	}
}
