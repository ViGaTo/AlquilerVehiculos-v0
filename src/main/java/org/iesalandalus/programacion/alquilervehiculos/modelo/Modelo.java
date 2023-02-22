package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;


public class Modelo {

	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;
	
	public Modelo() {
		
	}
	
	public void comenzar() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();
	}
	
	public void terminar() {
		System.out.println("El programa ha finalizado.");
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(new Cliente(cliente));
	}
	
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		turismos.insertar(new Turismo(turismo));
	}
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if(alquiler == null)
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		
		Cliente clienteBuscado = clientes.buscar(alquiler.getCliente());
		Turismo turismoBuscado = turismos.buscar(alquiler.getTurismo());
		
		if(clienteBuscado == null)
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		
		if(turismoBuscado == null)
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		
		alquileres.insertar(new Alquiler(alquiler));
	}
	
	public Cliente buscar(Cliente cliente) throws OperationNotSupportedException {
		return clientes.buscar(new Cliente(cliente));
	}
	
	public Turismo buscar(Turismo turismo) throws OperationNotSupportedException {
		return turismos.buscar(new Turismo(turismo));
	}
	
	public Alquiler buscar(Alquiler alquiler) throws OperationNotSupportedException {
		return alquileres.buscar(new Alquiler(alquiler));
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if(alquileres.buscar(alquiler) == null)
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		
		alquileres.devolver(alquiler, fechaDevolucion);
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for(Alquiler alquiler : alquileres.get(cliente)) {
			alquileres.borrar(alquiler);
		}
		
		clientes.borrar(cliente);
	}
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for(Alquiler alquiler : alquileres.get(turismo)) {
			alquileres.borrar(alquiler);
		}
		
		turismos.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}
	
	public List<Cliente> getClientes(){
		List<Cliente> listaCliente = new ArrayList<>();
		
		for(Cliente cliente : clientes.get()) {
			listaCliente.add(new Cliente(cliente));
		}
		
		return listaCliente;
	}
	
	public List<Turismo> getTurismos(){
		List<Turismo> listaTurismo = new ArrayList<>();
		
		for(Turismo turismo : turismos.get()) {
			listaTurismo.add(new Turismo(turismo));
		}
		
		return listaTurismo;
	}
	
	public List<Alquiler> getAlquileres(){
		List<Alquiler> listaAlquiler = new ArrayList<>();
		
		for(Alquiler alquiler : alquileres.get()) {
			listaAlquiler.add(new Alquiler(alquiler));
		}
		
		return listaAlquiler;
	}
	
	public List<Alquiler> getAlquileres(Cliente cliente){
		List<Alquiler> listaAlquilerCliente = new ArrayList<>();
		
		for(Alquiler alquiler : alquileres.get(cliente)) {
			listaAlquilerCliente.add(new Alquiler(alquiler));
		}
		
		return listaAlquilerCliente;
	}
	
	public List<Alquiler> getAlquileres(Turismo turismo){
		List<Alquiler> listaAlquilerTurismo = new ArrayList<>();
		
		for(Alquiler alquiler : alquileres.get(turismo)) {
			listaAlquilerTurismo.add(new Alquiler(alquiler));
		}
		
		return listaAlquilerTurismo;
	}
}
