package com.ipartek.formacion.spring.servidorrestspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.servidorrestspring.entidades.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {}
