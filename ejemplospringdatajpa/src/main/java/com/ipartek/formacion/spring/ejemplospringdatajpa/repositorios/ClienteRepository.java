package com.ipartek.formacion.spring.ejemplospringdatajpa.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.spring.ejemplospringdatajpa.entidades.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	List<Cliente> findByApellidos(String apellidos);
	
	Page<Cliente> findByApellidos(String apellidos, Pageable pageable);

	// findByNombreCompleto("Lete García, Javier")
	// substring(:nombreCompleto, locate(',', :nombreCompleto) + 1)
	@Query("select c.id from Cliente c where c.nombre = substring(:nombreCompleto, locate(',', :nombreCompleto) + 1) and c.apellidos = substring(:nombreCompleto, 1, locate(',', :nombreCompleto) - 1)")
	Long findByNombreCompleto(String nombreCompleto);
}
