'use strict';

var url = '/usuarioservlets/api/roles/';

// Llamamos por GET al servidor REST y recibimos directamente una colección de roles
$.getJSON(url, function(roles) {
	console.log(roles);

	// Por cada rol que haya en roles
	$(roles).each(function() {
		// Creamos un <option></option> nuevo desde la nada
		$('<option>')
			// Cambiamos su valor al id del rol en cuestión P.e.: <option value=1></option>
			.val(this.id)
			// Modificamos el contenido de texto al nombre del rol P.e: <option value=1>ADMIN</option>
			.text(this.nombre)
			// Lo agregamos al select cuyo id es select-roles <select id="select-roles">...<option value=1>ADMIN</option></select>
			.appendTo($('#select-roles'));
	});

	// Cuando se modifique el valor seleccionado en el <select id="select-roles">
	$('#select-roles').on('change', function() {
		console.log('Cambio select');

		// Si no se ha creado todavía ningún <select id="select-usuarios"> 
		if ($('#select-usuarios').length == 1) {
			// Borramos el desplegable de usuarios
			$('#select-usuarios').remove();			
		}
		
		// Al <select id="select-roles">
		$('#select-roles')
			// Le insertamos después un elemento de HTML (<select class="form-control" id="select-usuarios">)
			.after($('<select class="form-control" id="select-usuarios">')
				// Y le agregamos dentro un aop
				.append($('<option>Selecciona un usuario</option>')));

		// Cuando cambie el valor seleccionado en <select id="select-usuarios">
		$('#select-usuarios').on('change', function() {
			// Modificamos la URL del navegador para que nos lleve al detallle de ese usuario
			location.href = '/usuarioservlets/admin/usuario?id=' + $('#select-usuarios').val();
		});


		// Tomamos el valor seleccionado del <select id="select-roles">
		var id = $('#select-roles').val();

		console.log(id);

		// Lanzamos una petición AJAX a la dirección /usuarioservlets/api/roles/1/usuarios
		$.getJSON(url + id + '/usuarios', function(usuarios) {
			// Al llegar la respuesta recorremos los objetos de tipo usuario de uno en uno
			$(usuarios).each(function() {
				// Por cada objeto de tipo usuario
				console.log(this);
				// Añadimos al <select id="select-usuarios"> un <option> cuyo value será el id del rol y el texto será el email
				$('#select-usuarios').append($('<option>').val(this.id).text(this.email));
			});
		});
	});
});
