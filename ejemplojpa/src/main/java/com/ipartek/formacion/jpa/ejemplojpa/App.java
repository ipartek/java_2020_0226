package com.ipartek.formacion.jpa.ejemplojpa;

import java.time.LocalDate;

import com.ipartek.formacion.jpa.ejemplojpa.accesodatos.AccesoDatosException;
import com.ipartek.formacion.jpa.ejemplojpa.accesodatos.ClienteJpaDao;
import com.ipartek.formacion.jpa.ejemplojpa.accesodatos.Dao;
import com.ipartek.formacion.jpa.ejemplojpa.entidades.Cliente;

public class App 
{
    public static void main( String[] args )
    {
       	try {		
    		Dao<Cliente> dao = new ClienteJpaDao();
    		
			for(int i = 1; i < 10; i++) {
				dao.agregar(new Cliente(null, "Nombre" + 1, "Apellidos" + 1, "0000000" + i + (char)('A' + i), LocalDate.now()));
			}
			
			dao.borrar(7L);
			
			System.out.println(dao.obtenerPorId(1L));
			
			dao.modificar(new Cliente(2L, "Juan", "Juanes", "87654321A", LocalDate.now()));
			
			for(Cliente cliente: dao.obtenerTodos()) {
				System.out.println(cliente);
			}		
		} catch (AccesoDatosException e) {
			System.out.println("Error de acceso a datos:" + e.getMessage());
		}
    }
}
