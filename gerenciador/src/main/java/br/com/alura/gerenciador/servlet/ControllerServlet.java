package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.controller.Acao;
//import br.com.alura.gerenciador.controller.AlteraEmpresa;
//import br.com.alura.gerenciador.controller.ListaEmpresas;
//import br.com.alura.gerenciador.controller.MostraEmpresa;
//import br.com.alura.gerenciador.controller.NovaEmpresa;
//import br.com.alura.gerenciador.controller.NovaEmpresaForm;
//import br.com.alura.gerenciador.controller.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet(urlPatterns="/entrada")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

//		HttpSession sessao = request.getSession();
//		boolean usuarioLogado = (sessao.getAttribute("usuarioLogado") != null);
//		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//
//		if (acaoProtegida && !usuarioLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}

		String nomeDaClasse = "br.com.alura.gerenciador.controller." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); // carrega a classe com esse nome
			Object acao = (Acao) classe.newInstance();
			nome = ((Acao) acao).executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		System.out.println(nome);

		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}

//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//			
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}

	}

}
