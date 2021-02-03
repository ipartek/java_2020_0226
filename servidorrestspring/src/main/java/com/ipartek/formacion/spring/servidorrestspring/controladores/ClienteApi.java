package com.ipartek.formacion.spring.servidorrestspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.servidorrestspring.entidades.Cliente;
import com.ipartek.formacion.spring.servidorrestspring.repositorios.Dao;

@RestController
@RequestMapping("/api/clientes")
public class ClienteApi {
	@Autowired
	private Dao<Cliente> dao;
	
	@GetMapping
	public Iterable<Cliente> get() {
		return dao.obtenerTodos();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> getPorId(@PathVariable Long id) {
		Cliente cliente = dao.obtenerPorId(id);
		
		if(cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente post(@RequestBody Cliente cliente) {
		return dao.insertar(cliente);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> put(@PathVariable Long id, @RequestBody Cliente cliente) {
		if(id != cliente.getId()) {
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Cliente>(dao.modificar(cliente), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Long id) {
		try {
			dao.borrar(id);
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
}
