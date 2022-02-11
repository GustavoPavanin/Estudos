package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JPAUtil;

public class PerformanceConsultas {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		PedidoDAO pedidoDao = new PedidoDAO(em);
		
		Pedido pedido = pedidoDao.buscarPedidoComCliente(12l);
		
		em.close();
		System.out.println(pedido.getClienteId().getNome());
	}
	
}
