package com.ipartek.formacion.spring.uf2176_3;

import static com.ipartek.formacion.spring.uf2176_3.bibliotecas.Consola.leerBigDecimal;
import static com.ipartek.formacion.spring.uf2176_3.bibliotecas.Consola.leerString;
import static com.ipartek.formacion.spring.uf2176_3.bibliotecas.Consola.pl;
import static com.ipartek.formacion.spring.uf2176_3.bibliotecas.Consola.mostrarErrores;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.ipartek.formacion.spring.uf2176_3.accesodatos.MedicamentoDao;
import com.ipartek.formacion.spring.uf2176_3.accesodatos.MedicamentoDaoJdbc;
import com.ipartek.formacion.spring.uf2176_3.entidades.Medicamento;

//@SpringBootApplication
public class Uf21763Application {

	private static final String OPC_SALIR = "0";
	private static final String OPC_ALTA = "1";
	private static final String OPC_BAJA = "2";
	private static final String OPC_CONSULTA = "3";
	
	private static final MedicamentoDao DAO = MedicamentoDaoJdbc.getInstancia();
	
	private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
	
	public static void main(String[] args) {
		//SpringApplication.run(Uf21763Application.class, args);
		
		try {
			String opcion;
			
			do {
				mostrarMenu();
				opcion = recibirOpcion();
				procesarOpcion(opcion);
			} while(!OPC_SALIR.equals(opcion));
		} catch (Exception e) {
			pl("ERROR FATAL");
			pl("No se puede continuar con la aplicación");
			mostrarErrores(e);
		}
		
	}

	private static void mostrarMenu() {
		pl("MENU MEDICAMENTOS");
		pl("-----------------");
		pl(OPC_ALTA + ": Alta");
		pl(OPC_BAJA + ": Baja");
		pl(OPC_CONSULTA + ": Consulta");
		pl("-----------------");
		pl(OPC_SALIR + ": Salir");
		pl("-----------------");
	}

	

	private static String recibirOpcion() {
		return leerString("opción");
	}

	private static void procesarOpcion(String opcion) {
		switch(opcion) {
		case OPC_ALTA:
			alta();
			break;
		case OPC_BAJA:
			baja();
			break;
		case OPC_CONSULTA:
			consulta();
			break;
		case OPC_SALIR:
			pl("Saliendo de la aplicación");
			break;
		default:
			pl("Opción no reconocida");
		}
	}

	private static void alta() {
		boolean insercionCorrecta;
		Medicamento medicamento = null;
		
		do {
			medicamento = pedirMedicamento();
			
			try {
				insercionCorrecta = true;
				DAO.agregar(medicamento);
			} catch (Exception e) {
				insercionCorrecta = false;
				mostrarErrores(e);
			} 
		} while (!insercionCorrecta);
	}

	private static void baja() {
		boolean borradoCorrecto;
		String referencia; 
		do {
			referencia = leerString("referencia");
			try {
				borradoCorrecto = true;
				DAO.borrar(referencia);
			} catch (Exception e) {
				borradoCorrecto = false;
				mostrarErrores(e);
			}
		} while (!borradoCorrecto);
	}

	

	private static void consulta() {
		Iterable<Medicamento> medicamentos = DAO.obtenerTodos();
		
		for(Medicamento medicamento: medicamentos) {
			mostrarLineaMedicamento(medicamento);
		}
	}
	
	private static void mostrarLineaMedicamento(Medicamento medicamento) {
		// TODO: Mejorar el aspecto de las líneas de medicamentos
		pl(medicamento);
	}

	private static Medicamento pedirMedicamento() {
		Medicamento medicamento;
		
		String referencia, nombre;
		BigDecimal precio = null;
		
		Set<ConstraintViolation<Medicamento>> errores;
		
		do {
			referencia = leerString("referencia");
			nombre = leerString("nombre");
			do {
				try {
					precio = leerBigDecimal("precio");
				} catch (Exception e) {
					pl("El precio debe ser un número con decimales opcionales");
				} 
			} while (precio == null);
			
			medicamento = new Medicamento(null, referencia, nombre, precio);
			
			errores = VALIDATOR.validate(medicamento);
			
			for(ConstraintViolation<Medicamento> error: errores) {
				pl(error.getPropertyPath() + ": " + error.getMessage());
			}
		} while (errores.size() > 0);
		
		return medicamento;
	}
	
}
