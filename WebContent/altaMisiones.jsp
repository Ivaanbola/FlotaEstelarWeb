<%@page import="com.sun.javafx.fxml.ParseTraceElement"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controlador.GMisiones"%>
<%@page import="modelo.Misiones"%>
<%@page import="modelo.Nave"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<title>Formulario Misiones</title>
</head>
<body>
	<div id="contenedor">

		<%@include file="/includes/header.inc.jsp"%>
		<%@include file="/includes/nav.inc.jsp"%>

		<section>
			<%
				String id = "0";
				if (request.getAttribute("id") != null) {
					id = request.getAttribute("id").toString();
				}
				Misiones m = new Misiones();
				m.buscarID(Integer.parseInt(id));
				Nave nave = new Nave();
				nave.buscarID(Integer.parseInt(id));
			%>

			<div class="formulario">
				<h3>Insertar</h3>
				<form name="usuario" action="GMisiones" method="post">
					<ul>
						<li><label>Nombre:</label><input type="text" name="nombre"
							id="nombre"
							value='<%if (request.getAttribute("id") != null)
				out.print(m.getNombre());%>'>
						<li><label>Nave:</label><select name="nave" id="nave">
								<%
									if (nave.listarNaves() != null) {
										out.print("<option value=0>Seleccion</option>");
										for (Nave p : nave.listarNaves()) {
											out.print(" <option value=" + p.getId() + ">" + p.getNombre() + "</option>");
										}
									} else
										out.print(" <option>No hay naves añadidas</option>");
								%>

						</select>
						<li><label>Descripcion:</label><input type="text"
							name="descripcion" id="descripcion"
							value='<%if (request.getAttribute("id") != null)
				out.print(m.getDescripcion());%>'>
							<input type="hidden" name="id" id="id"
							value='<%if (request.getAttribute("id") != null)
				out.print(m.getId());%>'>
							<input type="hidden" name="opcion" value="1">
						<li><input type="submit" name="enviar" value="Guardar">
					</ul>
				</form>
				<a href="misiones.jsp">Volver a la lista</a>
				<%
					if (request.getAttribute("id") != null)
						out.print("<a href='GMisiones?opcion=2&id=" + m.getId() + "'>Borrar</a>");
				%>
			</div>

		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>