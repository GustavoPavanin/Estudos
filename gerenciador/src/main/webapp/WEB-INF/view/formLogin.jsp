<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="entrada" var="linkServletNovaEmpresa"/>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core">

<body>
	
	<form action="${linkServletNovaEmpresa}" method="post">
		
		Login: <input type="text" name="login" />
		</br>
		Senha: <input type="password" name="senha" />
		<input type="text" name="acao" value="Login" hidden/>	
		<input type="submit"/>
	
	</form>
</body>
</html>
