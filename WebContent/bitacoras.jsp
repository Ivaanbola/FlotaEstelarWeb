<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Bitacoras</title>
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
				<h3>Insertar</h3>
				<form name="usuario" action="" method="post"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Nave:</td>
							<td><input type="text" maxlength="50" name="nombre"
								id="nombre" required></td>
						</tr>
						<tr>
							<td>Fecha:</td>
							<td><input type="text" name="capitan" required></td>
						</tr>
						<tr>
							<td>Audio:</td>
						</tr>
						<tr>
							<td colspan="2"><input type="file" name="foto"></td>
						</tr>
						<tr>
							<td colspan="1"><input type="button" onclick="validar()"
								value="Guardar"></td>
						</tr>
					</table>
				</form>
			</div>

			<div class="formulario">
				<h3>Borrar</h3>
				<form name="usuario" action="" method="post"
					enctype="multipart/form-data">
					<table >
						<tr>
							<td>Inserta el ID:</td>
							<td><input type="number" name="id" id="id" required></td>
						</tr>
							<tr>
							<td><input type="button" onclick="validar()"
								value="Guardar"></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="formulario">
				<h3>Listar</h3>
				<table class="lista">
					<tr>
						<th>ID</th>
						<th>Nave</th>
						<th>Fecha</th>
						<th>Audio</th>
					</tr>
					<tr>
					</tr>
				</table>
			</div>


		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
