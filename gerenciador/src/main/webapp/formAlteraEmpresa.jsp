<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="entrada" var="linkEntradaServlet" />
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core">

<body>

	<form action="${linkEntradaServlet}" method="post">

		Nome: <input type="text" name="nome" value="${empresa.nome}" /> </br> Data de
		Abertura: <input type="text" name="data"
			value="<fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
		<input type="text" name="id" value="${empresa.id}" hidden/>
		<input type="text" name="acao" value="AlteraEmpresa" hidden/>				
		<input type="submit" />

	</form>
</body>
</html>
