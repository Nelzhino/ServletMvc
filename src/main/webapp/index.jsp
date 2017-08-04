<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Productos</title>
</head>
<body>

	<div class="container">
		<h2>Basic Table Products in Servlet</h2>
		<p>Show all products in the table</p>
		<div>
			<button type="button" class="btn btn-info" onclick="location.href='create.jsp'">Crear Producto</button>
			
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>Accion</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${listadoProductos}">
					<tr>
						<td>${producto.nombre}</td>
						<td>${producto.descripcion}</td>
						<td>${producto.valor}</td>
						<c:url var="linkTemp" value="Producto">
							<c:param name="instruccion" value="2"></c:param>
							<c:param name="codigo" value="${producto.codigo}"></c:param>
						</c:url>
						
						<c:url var="linkTempDel" value="Producto">
							<c:param name="instruccion" value="4"></c:param>
							<c:param name="codigo" value="${producto.codigo}"></c:param>
						</c:url>
						<td>
							<a href="${linkTemp}">Actualizar</a> 
							-- 
							<a href="${linkTempDel}">Borrar</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>


</body>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>