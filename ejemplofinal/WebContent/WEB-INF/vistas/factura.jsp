<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<table>
	<caption>Cliente</caption>
	
	<tbody>
		<tr>
			<th scope="row">Id</th>
			<td>${cliente.id}</td>
		</tr>
		<tr>
			<th scope="row">Nombre</th>
			<td>${cliente.nombre}</td>
		</tr>
		<tr>
			<th scope="row">Apellidos</th>
			<td>${cliente.apellidos}</td>
		</tr>
		<tr>
			<th scope="row">CIF</th>
			<td>${cliente.cif}</td>
		</tr>
		<tr>
			<th scope="row">Fecha de nacimiento</th>
			<td>${cliente.fechaNacimiento}</td>
		</tr>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
