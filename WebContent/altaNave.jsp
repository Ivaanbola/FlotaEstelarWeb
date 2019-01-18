<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sun.javafx.fxml.ParseTraceElement"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="controlador.GNave"%>
<%@page import="modelo.Nave"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<title>Formulario Nave</title>
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
				Nave nave = new Nave();
				nave.buscarID(Integer.parseInt(id));
			%>
			<div class="formulario">
				<h3>Insertar</h3>
				<form name="usuario" action="GNave" method="post"
					enctype="multipart/form-data">
					<ul>
						<li><label>Nombre:</label><input type="text" name="nombre"
							id="nombre"
							value='<%if (request.getAttribute("id") != null)
				out.print(nave.getNombre());%>'>
						<li><label>Capitan:</label><input type="text" name="capitan"
							id="capitan"
							value='<%if (request.getAttribute("id") != null)
				out.print(nave.getCapitan());%>'>
						<li><label>Matricula:</label><input type="text"
							name="matricula" id="matricula"
							value='<%if (request.getAttribute("id") != null)
				out.print(nave.getMatricula());%>'>
						<li><label>Tipo:</label><input type="text" name="tipo"
							id="tipo"
							value='<%if (request.getAttribute("id") != null)
				out.print(nave.getTipo());%>'>
						<li><label>Foto:</label><input type="file" name="foto"
							id="foto"
							value='<%if (request.getAttribute("id") != null)
				out.print(nave.getFoto());%>'>
							<input type="hidden" name="id" id="id"
							value='<%if (request.getAttribute("id") != null)
				out.print(nave.getId());%>'>
							<input type="hidden" name="opcion" value="1">
						<li><input type="submit" name="enviar" value="Guardar">
					</ul>
				</form>
				<a href="nave.jsp">Volver a la lista</a>
				<%
					if (request.getAttribute("id") != null)
						out.print("<a href='GNave?opcion=2&id=" + nave.getId() + "'>Borrar</a>");
				%>
			</div>

		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>