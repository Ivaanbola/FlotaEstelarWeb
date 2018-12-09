<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controlador.GMisiones"%>
<%@page import="modelo.Misiones"%>
<%@page import="modelo.Nave"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Misiones</title>


</head>
<body>
	<div id="contenedor">

		<%@include file="/includes/header.inc.jsp"%>
		<%@include file="/includes/nav.inc.jsp"%>

		<section>

			<div class="formulario">
				<h1>Lista Misiones</h1>
				<table class="lista">
					<tr>
						<th>Nombre</th>
						<th>Nave</th>
						<th>Descripcion</th>
					</tr>
					<%
						Misiones misiones = new Misiones();
						Nave nave = new Nave();
						if (misiones.listarMisiones() != null)
							for (Misiones p : misiones.listarMisiones()) {
								nave.buscarID(p.getNave());
					%>
					<tr>
						<td><%=p.getNombre()%></td>
						<td>
							<%
								if (nave.getNombre() != null)
											out.print(nave.getNombre());
							%>
						</td>
						<td><%=p.getDescripcion()%></td>
						<td><a href="GMisiones?opcion=3&id=<%=p.getId()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</table>



				<a href="GMisiones?opcion=3&id=0">Dar de alta una nueva mision</a>
			</div>

		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
