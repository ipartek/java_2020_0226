var url = '/servidorrestservlets/api/clientes/';

var idModificar = null;

$(function() { //Al cargar el documento HTML completo...
	listar();
	
	$('form').on('submit', function(e) {
		e.preventDefault();
		
		var nombre = $('#nombre').val();
		
		var fecha = $('#fecha').val();
		
		var partesFecha = fecha.split('-');
		
		var fechaNacimiento = { year: partesFecha[0], month: partesFecha[1], day: partesFecha[2] };
		
		var cliente = { nombre, fechaNacimiento };
		
		console.log(fecha, partesFecha, fechaNacimiento, cliente);
		
		if(idModificar) {
			cliente.id = idModificar;
			
			$.ajax(url + idModificar, {
				method: 'PUT',
				data: JSON.stringify(cliente)
			}).then(listar);
			
			id = null;
			
			$('#nombre').val('');
			$('#fecha').val('');			
		} else {
			$.ajax(url, {
				method: 'POST',
				data: JSON.stringify(cliente)
			}).then(listar);
			
		}
		
	});
});

function listar() {
	$.getJSON(url, function(clientes) { //Lanzamos una petición REST de tipo GET a la url /api/clientes
		console.log(clientes);

		$('tbody').empty();

		$(clientes).each(function() { //Por cada uno de los clientes recibidos
			var fechaNacimiento = this.fechaNacimiento ? this.fechaNacimiento.year + '-' + this.fechaNacimiento.month + '-' + this.fechaNacimiento.day : '';
			
			$('<tr><th>' + this.id + '</th><td>' + this.nombre + '</td><td>' 
			+ fechaNacimiento
			+ '</td><td><a href="javascript:borrar(' + this.id + ')">Borrar</a> ' 
			+ '<a href="javascript:editar(' + this.id + ')">Editar</a></td></tr>').appendTo($('tbody')); //Lo colocamos como filas dentro del tbody
		});
	});
}

function borrar(id) {
	$.ajax(url + id, { method: 'DELETE' }).then(listar);
}

function editar(id) {
	$.getJSON(url + id, function(cliente) {
		$('#nombre').val(cliente.nombre);
		$('#fecha').val(cliente.fechaNacimiento.year + '-' +
           ('0'+ cliente.fechaNacimiento.month).slice(-2) + '-' +
           ('0'+ cliente.fechaNacimiento.day).slice(-2));
		idModificar = cliente.id;
	});
}
