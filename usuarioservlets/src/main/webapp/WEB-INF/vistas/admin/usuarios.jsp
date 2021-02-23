<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Listado de usuarios</h2>

<div class="form-inline">
	<select id="select-roles" class="form-control">
		<option>Selecciona un Rol</option>
	</select>
</div>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<caption>Listado de usuarios</caption>
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Email</th>
				<th scope="col">Rol</th>
				<th scope="col">Descripción del rol</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<th scope="row">${u.id}</th>
					<td>
					<input class="form-control" id="email_${u.id}" value="${u.email}" /></td>
					<td><select class="form-control" id="rol_${u.id}">
							<option value="0">Selecciona un rol</option>

							<c:forEach items="${roles}" var="rol">
								<option value="${rol.id}"
									${rol.id == u.rol.id ? 'selected' : '' }>${rol.nombre}:
									${rol.descripcion}</option>
							</c:forEach>
					</select></td>
					<td>${u.rol.descripcion}</td>
					<td><a class="btn btn-primary" href="admin/usuario?id=${u.id}">Editar</a>
						<a class="btn btn-danger" href="admin/borrar?id=${u.id}"
						onclick="return confirm('¿Estás seguro de que quieres borrar el usuario ${u.email}?')">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<a class="btn btn-primary" href="admin/usuario">Añadir</a>
	</div>
</div>

<script src="js/clienterest.js"></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>