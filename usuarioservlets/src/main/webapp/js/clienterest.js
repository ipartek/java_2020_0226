'use strict';

var url = '/usuarioservlets/api/roles/';

$.getJSON(url, function(roles) {
	console.log(roles);
	
	$(roles).each(function() {
		$('<option>').val(this.id).text(this.nombre).appendTo($('#select-roles'));
	});
});
