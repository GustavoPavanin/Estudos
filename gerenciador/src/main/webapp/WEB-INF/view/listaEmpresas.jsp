<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body>
	<c:import url="header.jsp"/>

	Usuario Logado: ${ usuarioLogado.login }
	
	<br>
	<c:if test="${not empty empresa}"> 
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	<br /> Lista de empresas:
	<br />
	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.id}- ${empresa.nome} - <fmt:formatDate
					value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" /> <a
				href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a> <a
				href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Excluir</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>