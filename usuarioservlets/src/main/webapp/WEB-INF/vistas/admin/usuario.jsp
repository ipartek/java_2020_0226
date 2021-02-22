<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Formulario de usuario</h2>

<form method="post">
	<input type="hidden" name="id" value="${requestScope.usuario.id}" />
	
	<div class="form-group row">
		<label for="email" class="col-sm-2 col-form-label">Correo electrónico</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email" name="email" value="${requestScope.usuario.email}">
		</div>
	</div>
	
	<div class="form-group row">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password" name="password">
		</div>
	</div>
	<div class="form-group row">
		<label for="password" class="col-sm-2 col-form-label">Rol</label>
		<div class="col-sm-10">
			<select class="form-control" name="rol">
				<option value="0">Selecciona un rol</option>
				
				<c:forEach items="${roles}" var="rol">
					<option value="${rol.id}" ${rol.id == requestScope.usuario.rol.id ? 'selected' : '' }>${rol.nombre}: ${rol.descripcion}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>