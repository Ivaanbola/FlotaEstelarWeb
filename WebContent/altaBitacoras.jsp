<%@page import="com.sun.javafx.fxml.ParseTraceElement"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controlador.GBitacoras"%>
<%@page import="modelo.Bitacoras"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<title>Formulario Bitacoras</title>
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
				Bitacoras bitacoras = new Bitacoras();
				bitacoras.buscarID(Integer.parseInt(id));
			%>
			<div class="formulario">
				<h3>Insertar</h3>
				<form name="usuario" action="GBitacoras" method="post">
					<ul>
						<li><label>Nave:</label><input type="text" name="nave"
							id="nave"
							value='<%if (request.getAttribute("id") != null)
				out.print(bitacoras.getNave());%>'>
						<li><label>Fecha:</label><input type="text" name="fecha"
							id="fecha" placeholder="dd/mm/yyyy"
							value='<%if (request.getAttribute("id") != null)
				out.print(bitacoras.getFecha());%>'>
						<li><label>Audio:</label><input type="file" name="audio"
							id="audio"
							value='<%if (request.getAttribute("id") != null)
				out.print(bitacoras.getAudio());%>'>
							<input type="hidden" name="id" id="id"
							value='<%if (request.getAttribute("id") != null)
				out.print(bitacoras.getId());%>'>
							<input type="hidden" name="opcion" value="1">
						<li><input type="submit" name="enviar" value="Guardar">
					</ul>
				</form>

				<a href="bitacoras.jsp">Volver a la lista</a>
				<%
					if (request.getAttribute("id") != null)
						out.print("<a href='GBitacoras?opcion=2&id=" + bitacoras.getId() + "'>Borrar</a>");
				%>
			</div>

		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>

</body>
</html>