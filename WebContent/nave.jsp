<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="controlador.GNave"%>
<%@page import="modelo.Nave"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Nave</title>
<script>
	function pinchaboton() {
		alert("No toques las cosas de tocar");
	}
</script>

</head>
<body>
	<div id="contenedor">

		<%@include file="/includes/header.inc.jsp"%>
		<%@include file="/includes/nav.inc.jsp"%>

		<section>
			<div class="formulario">
				<h1>Lista Naves</h1>
				<table class="lista">
					<tr>
						<th>Nave</th>
						<th>Capitan</th>
						<th>Matricula</th>
						<th>Tipo</th>
						<th>Foto</th>
					</tr>
					<%
						Nave nave = new Nave();
					if(nave.listarNaves()!=null)
						for (Nave p : nave.listarNaves()) {
					%>
					<tr>
						<td><%=p.getNombre()%></td>
						<td><%=p.getCapitan()%></td>
						<td><%=p.getMatricula()%></td>
						<td><%=p.getTipo()%></td>
						<td><%=p.getFoto()%></td>
						<td><a href="GNave?opcion=3&id=<%=p.getId()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</table>

				<a href="GNave?opcion=3&id=0">Dar de alta una nueva Nave</a>
			</div>
		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
