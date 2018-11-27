<%@page import="dao.DAOTripulantes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelo.Tripulantes"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Tripulantes</title>
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

		<section class="listados">

			<div class="formulario">
				<h1>Lista tripulantes</h1>
				<table>
					<tr>
						<th>Nombre</th>
						<th>Cargo</th>
						<th>Sexo</th>
						<th>Experiencia</th>
						<th>Origen</th>
						<th>Raza</th>
						<th>Edad</th>
						<th>Foto</th>
						<th>Nave</th>
					</tr>

					<%
						Tripulantes tripulantes = new Tripulantes();
						for (Tripulantes p : tripulantes.listarTripulantes()) {
					%>

					<tr>
						<td><%=p.getNombre()%></td>
						<td><%=p.getCargo()%></td>
						<td><%=p.getSexo()%></td>
						<td><%=p.getExperiencia()%></td>
						<td><%=p.getOrigen()%></td>
						<td><%=p.getRaza()%></td>
						<td><%=p.getEdad()%></td>
						<td><%=p.getFoto()%></td>
						<td><%=p.getNave()%></td>
						<td><a href="GTripulantes?opcion=3&id=<%=p.getId()%>">Editar</a></td>
					</tr>

					<%
						}
					%>



				</table>

				<a href="GTripulantes?opcion=3&id=0">Dar de alta a un tripulante</a>
			</div>

		</section>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
