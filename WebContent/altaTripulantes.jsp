<%@page import="com.sun.javafx.fxml.ParseTraceElement"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="controlador.GTripulantes"%>
<%@page import="modelo.Tripulantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<section>
			<%
				String id = request.getAttribute("id").toString();
				Tripulantes tripu = new Tripulantes();
				tripu.buscarID(Integer.parseInt(id));
			%>

			<div class="formulario">
				<h3>Insertar</h3>
				<form name="usuario" action="GTripulantes" method="post">
					<ul>

						<li><label>Nombre:</label><input type="text" name="nombre"
							id="nombre" value='<%out.print(tripu.getNombre());%>'>
						<li><label>Cargo:</label><input type="text" name="cargo"
							id="cargo" value='<%out.print(tripu.getCargo());%>'>
						<li><label>Sexo:</label><input type="number" name="sexo"
							id="sexo" value='<%out.print(tripu.getSexo());%>'>
						<li><label>Experiencia:</label><input type="number"
							name="experiencia" id="experiencia"
							value='<%out.print(tripu.getExperiencia());%>'>
						<li><label>Origen:</label><input type="text" name="origen"
							id="origen" value='<%out.print(tripu.getOrigen());%>'>
						<li><label>Raza:</label><input type="text" name="raza"
							id="raza" value='<%out.print(tripu.getRaza());%>'>
						<li><label>Edad:</label><input type="number" name="edad"
							id="edad" value='<%out.print(tripu.getEdad());%>'>
						<li><label>Foto:</label><input type="file" name="foto"
							id="foto" value='<%out.print(tripu.getFoto());%>'>
						<li><label>Nave:</label><input type="number" name="nave"
							id="nave" value='<%out.print(tripu.getNave());%>'>
						<li><input type="submit" name="enviar" value="Guardar">
					</ul>
				</form>
				<a href="tripulantes.jsp">Volver a la lista</a> <a
					href="GTripulantes?opcion=2&id=<%=tripu.getId()%>">Borrar</a>
			</div>

		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
