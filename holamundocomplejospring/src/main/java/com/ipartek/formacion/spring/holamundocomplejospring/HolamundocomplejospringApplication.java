package com.ipartek.formacion.spring.holamundocomplejospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolamundocomplejospringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HolamundocomplejospringApplication.class, args);
	}

	@Autowired
	private ProcesadorMensajes procesador;

	@Override
	public void run(String... args) throws Exception {
		procesador.procesar();
	}

}
