<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controlador.GBitacoras"%>
<%@page import="modelo.Bitacoras"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<title>Bitacoras</title>


</head>
<body>
	<div id="contenedor">

		<%@include file="/includes/header.inc.jsp"%>
		<%@include file="/includes/nav.inc.jsp"%>

		<section>

			<div class="formulario">
				<h1>Lista Bitacoras</h1>
				<table class="lista">
					<tr>
						<th>Nave</th>
						<th>Fecha</th>
						<th>Audio</th>
					</tr>
					<%
						Bitacoras bitacoras = new Bitacoras();
						for (Bitacoras p : bitacoras.listarBitacoras()) {
					%>
					<tr>
						<td><%=p.getNave()%></td>
						<td><%=p.getFecha()%></td>
						<td><%=p.getAudio()%></td>
						<td><a href="GBitacoras?opcion=3&id=<%=p.getId()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</table>



				<a href="GBitacoras?opcion=3&id=0">Dar de alta un nuevo Bitacoras</a>
			</div>


		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
