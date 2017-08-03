<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Editar Producto</title>
</head>
<body>
	<div class="container">
		<h2>Form edit product</h2>
		<form action="Producto" method="get">
			<input type="hidden" name="instruccion" value="3">
			<input type="hidden" name="codigo" value="${dataProducto.codigo}">
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" id="nombre" placeholder="Enter nombre"
					name="nombre" value="${dataProducto.nombre}">
			</div>
			<div class="form-group">
				<label for="descripcion">Descripción:</label> <input type="text"
					class="form-control" id="descripcion"
					placeholder="Enter descripcion" name="descripcion" value="${dataProducto.descripcion}">
			</div>
			<div class="form-group">
				<label for="valor">Valor:</label> <input type="text"
					class="form-control" id="valor" placeholder="Enter valor"
					name="valor" maxlength="4" size="5" value="${dataProducto.valor}">
			</div>
			<button type="submit" class="btn btn-default">Guardar</button>
		</form>
	</div>
</body>
</html>