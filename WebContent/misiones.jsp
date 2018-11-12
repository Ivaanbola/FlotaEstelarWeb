<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Misiones</title>
<script>
	function pinchaboton() {
		alert("No toques las cosas de tocar");
	}
</script>

</head>
<body>
	<div id="contenedor">

		<jsp:include page="/includes/header.inc.jsp"></jsp:include>
		<jsp:include page="/includes/nav.inc.jsp"></jsp:include>

		<section>

			<div class="formulario">
				<h3>Insertar</h3>
				<form name="usuario" action="" method="post"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Nombre:</td>
							<td><input type="text" maxlength="50" name="nombre"
								id="nombre" required></td>
						</tr>
						<tr>
							<td>Nave:</td>
							<td><input type="text" name="capitan" required></td>
						</tr>
						<tr>
							<td>Descripcion:</td>
							<td><input type="text" maxlength="20" name="matricula"
								required></td>
						</tr>
						<tr>
							<td colspan="1"><input type="button" onclick="validar()"
								value="Guardar"></td>
						</tr>
					</table>
				</form>
			</div>

			<div class="formulario">
				<h3>Actualizar</h3>
				<form name="usuario" action="" method="post"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Inserta el ID:</td>
							<td><input type="number" name="id" id="id" required></td>
						</tr>
						<tr>
							<td>Nombre:</td>
							<td><input type="text" maxlength="50" name="nombre"
								id="nombre" required></td>
						</tr>
						<tr>
							<td>Nave:</td>
							<td><input type="text" name="capitan" required></td>
						</tr>
						<tr>
							<td>Descripcion:</td>
							<td><input type="text" maxlength="20" name="matricula"
								required></td>
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
					<table>
						<tr>
							<td>Inserta el ID:</td>
							<td><input type="number" name="id" id="id" required></td>
						</tr>
						<tr>
							<td><input type="button" onclick="validar()" value="Guardar"></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="formulario">
				<h3>Listar</h3>
				<table class="lista">
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Nave</th>
						<th>Descripcion</th>
					</tr>
					<tr>
					</tr>
				</table>
			</div>


		</section>
		<jsp:include page="/includes/aside.inc.jsp"></jsp:include>
		<jsp:include page="/includes/footer.inc.jsp"></jsp:include>
	</div>
</body>
</html>
