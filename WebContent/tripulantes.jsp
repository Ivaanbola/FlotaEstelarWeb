<%@page import="dao.DAOTripulantes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelo.Tripulantes"%>
<%@ page import="modelo.Nave"%>
<%@ page import="modelo.Sexo"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Tripulantes</title>

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
						Nave nave = new Nave();
						Sexo sexo = new Sexo();
						if (tripulantes.listarTripulantes() != null)
							for (Tripulantes p : tripulantes.listarTripulantes()) {
								nave.buscarID(p.getNave());
								sexo.buscarID(p.getSexo());
					%>

					<tr>
						<td><%=p.getNombre()%></td>
						<td><%=p.getCargo()%></td>
						<td>
							<%
								if (sexo.getNombre() != null)
											out.print(sexo.getNombre());
							%>
						</td>
						<td><%=p.getExperiencia()%></td>
						<td><%=p.getOrigen()%></td>
						<td><%=p.getRaza()%></td>
						<td><%=p.getEdad()%></td>
						<td><%=p.getFoto()%></td>
						<td>
							<%
								if (nave.getNombre() != null)
											out.print(nave.getNombre());
							%>
						</td>
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
