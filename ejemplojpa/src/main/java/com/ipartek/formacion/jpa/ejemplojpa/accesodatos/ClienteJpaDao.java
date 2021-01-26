package com.ipartek.formacion.jpa.ejemplojpa.accesodatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ipartek.formacion.jpa.ejemplojpa.entidades.Cliente;

public class ClienteJpaDao implements Dao<Cliente> {

	private final EntityManagerFactory emf;

	public ClienteJpaDao() {
		try {
			emf = Persistence.createEntityManagerFactory("com.ipartek.formacion.jpa.ejemplojpa");
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido conectar con el origen de datos", e);
		}
	}
	
	@Override
	public Iterable<Cliente> obtenerTodos() {
		try {
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			Iterable<Cliente> clientes = em.createQuery("from Cliente", Cliente.class).getResultList();
			em.getTransaction().commit();

			em.close();

			return clientes;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener todos los clientes", e);
		}
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		try {
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			Cliente cliente = em.find(Cliente.class, id);
			em.getTransaction().commit();

			em.close();

			return cliente;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener el cliente cuyo id es " + id, e);
		}
	}

	@Override
	public Cliente agregar(Cliente cliente) {
		try {
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();

			em.close();

			return cliente;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido agregar el cliente " + cliente, e);
		}
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		try {
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();

			em.close();

			return cliente;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido modificar el cliente " + cliente, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try {
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.remove(em.find(Cliente.class, id));
			em.getTransaction().commit();

			em.close();
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido borrar el cliente cuyo id es " + id, e);
		}
	}

}
