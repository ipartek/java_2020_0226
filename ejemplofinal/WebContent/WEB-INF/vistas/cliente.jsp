<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="cliente" method="post">
	<div class="form-group row">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre">
		</div>
	</div>
	<div class="form-group row">
		<label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="apellidos" name="apellidos">
		</div>
	</div>
	<div class="form-group row">
		<label for="cif" class="col-sm-2 col-form-label">CIF</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="cif" name="cif">
		</div>
	</div>
	<div class="form-group row">
		<label for="fecha-nacimiento" class="col-sm-2 col-form-label">Fecha de nacimiento</label>
		<div class="col-sm-10">
			<input type="date" class="form-control" id="fecha-nacimiento" name="fecha-nacimiento">
		</div>
	</div>
	
	<div class="form-group row">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">Dar de alta</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
