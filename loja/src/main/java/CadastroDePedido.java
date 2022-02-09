import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {
	public static void main(String[] args) {

		popularBancoDeDados();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);
		ClienteDAO clidao = new ClienteDAO(em);

		Produto produto = pdao.buscarPorId(1l);
		Cliente cliente = clidao.buscarPorId(1l);
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));

		PedidoDAO pedidoDao = new PedidoDAO(em);
		em.getTransaction().begin();
		pedidoDao.cadastrar(pedido);
		em.getTransaction().commit();
		
		
		BigDecimal valorTotal = pedidoDao.valorTotalVentido();
		System.out.println("Valor Total: " + valorTotal);
	}

	private static void popularBancoDeDados() {
		Categoria categoria = new Categoria("Instrumentos");
		Produto produto = new Produto("Banjo 5 cordas", "Banjo Bluegrass", new BigDecimal("2000"), categoria);

		Cliente cliente = new Cliente("Rodrigo", "123456");

		EntityManager em = JPAUtil.getEntityManager();
		ClienteDAO clidao = new ClienteDAO(em);
		ProdutoDAO pdao = new ProdutoDAO(em);
		CategoriaDAO cdao = new CategoriaDAO(em);
		em.getTransaction().begin();
		cdao.cadastrar(categoria);
		pdao.cadastrar(produto);
		em.getTransaction().commit();
		em.close();
	}
}
