package com.ipartek.formacion.spring.ejemplospringdatajpa;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.ipartek.formacion.spring.ejemplospringdatajpa.entidades.Cliente;
import com.ipartek.formacion.spring.ejemplospringdatajpa.repositorios.ClienteRepository;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class EjemplospringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringdatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClienteRepository repo) {
		return (args) -> {
			repo.save(new Cliente(null, "Jack", "Bauer"));
			repo.save(new Cliente(null, "Chloe", "O'Brian"));
			repo.save(new Cliente(null, "Kim", "Bauer"));
			repo.save(new Cliente(null, "David", "Palmer"));
			repo.save(new Cliente(null, "Michelle", "Dessler"));
			
			for(Cliente cliente: repo.findAll(Sort.by("nombre"))) {
				log.info(cliente.toString());
			}
			
			Optional<Cliente> cliente = repo.findById(1L);
			
			log.info(cliente.toString());
			
			repo.findByApellidos("Bauer", PageRequest.of(1, 1)).forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			Page<Cliente> pagina = repo.findAll(PageRequest.of(1,2));
			
			for(Cliente c: pagina) {
				log.info(c.toString());
			}
			
			log.info(repo.findByNombreCompleto("Palmer,David").toString());
		};
	}
}
