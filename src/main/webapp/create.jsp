<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<div class="container">
		<h2>Form create product</h2>
		<form action="Producto" method="get">
			<input type="hidden" name="instruccion" value="1">
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" id="nombre" placeholder="Enter nombre"
					name="nombre">
			</div>
			<div class="form-group">
				<label for="descripcion">Descripción:</label> <input type="text"
					class="form-control" id="descripcion"
					placeholder="Enter descripcion" name="descripcion">
			</div>
			<div class="form-group">
				<label for="valor">Valor:</label> <input type="text"
					class="form-control" id="valor" placeholder="Enter valor"
					name="valor" maxlength="4" size="5">
			</div>
			<button type="submit" class="btn btn-default">Guardar</button>
		</form>
	</div>

</body>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
