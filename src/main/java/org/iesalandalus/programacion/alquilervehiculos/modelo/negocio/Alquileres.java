package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	private static  List<Alquiler> coleccionAlquileres;
	
	public Alquileres(){
		coleccionAlquileres = new ArrayList<>();
	}
	
	public static List<Alquiler> get() {
		return new ArrayList<>(coleccionAlquileres);
	}
	
	public int getCantidad() {
		return coleccionAlquileres.size();
	}
	
	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws OperationNotSupportedException {
		for(Alquiler alquiler : coleccionAlquileres) {
			if(alquiler.getFechaDevolucion() == null) {
				if(alquiler.getCliente().equals(cliente))
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				
				if(alquiler.getTurismo().equals(turismo))
					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				
			}else if(!alquiler.getFechaDevolucion().isBefore(fechaAlquiler)) {
				if(alquiler.getCliente().equals(cliente))
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
			
				if(alquiler.getTurismo().equals(turismo))
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
			}
		}
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if(alquiler == null)
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		
		int i = coleccionAlquileres.indexOf(alquiler);
		if(i == -1)
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		
		alquiler.devolver(fechaDevolucion);
	}
	
	public List<Alquiler> get(Cliente cliente){
		List<Alquiler> alquileresCliente= new ArrayList<>();
		
		for(Alquiler alquiler : coleccionAlquileres) {
			if(alquiler.getCliente().equals(cliente)) {
				alquileresCliente.add(alquiler);
			}
		}
		
		return alquileresCliente;
	}
	
	public List<Alquiler> get(Turismo turismo){
		List<Alquiler> alquileresTurismo= new ArrayList<>();
		
		for(Alquiler alquiler : coleccionAlquileres) {
			if(alquiler.getTurismo().equals(turismo)) {
				alquileresTurismo.add(alquiler);
			}
		}
		
		return alquileresTurismo;
	}
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if(alquiler == null)
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		
		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		
		coleccionAlquileres.add(alquiler);
	}
	
	public Alquiler buscar(Alquiler alquiler) throws OperationNotSupportedException {
		Alquiler alquilerBuscado;
		
		if(alquiler == null)
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		
		int i = coleccionAlquileres.indexOf(alquiler);
		if(i == -1) {
			alquilerBuscado = null;
		}else {
			alquilerBuscado = new Alquiler(coleccionAlquileres.get(i));
		}
		
		return alquilerBuscado;
	}
	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if(alquiler == null)
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		
		int i = coleccionAlquileres.indexOf(alquiler);
		if(i == -1)
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		
		coleccionAlquileres.remove(alquiler);
	}
}
