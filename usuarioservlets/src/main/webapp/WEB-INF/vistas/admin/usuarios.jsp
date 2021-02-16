<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de usuarios</title>
</head>
<body>

	<h1>Usuario Servlets: Administración</h1>

	<h2>Listado de usuarios</h2>

	<table>
		<caption>Listado de usuarios</caption>
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Email</th>
				<th scope="col">Contraseña</th>
				<th scope="col">Rol</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<th scope="row">${u.id}</th>
					<td>${u.email}</td>
					<td>${u.password}</td>
					<td>${u.rol.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>