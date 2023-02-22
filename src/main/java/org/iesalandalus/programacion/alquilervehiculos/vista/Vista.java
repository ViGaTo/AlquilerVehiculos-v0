package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.format.DateTimeParseException;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {

	private Controlador controlador;
	
	public void setControlador(Controlador controlador){
		if(controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		
		this.controlador = controlador;
	}
	
	public void comenzar() {
		Consola.mostrarMenu();
		ejecutar(Consola.elegirOpcion());
	}
	
	public void terminar() {
		controlador.terminar();
	}
	
	private void ejecutar(Opcion opcion) {
		switch(opcion.ordinal()) {
		case 0:
			terminar();
			break;
			
		case 1:
			insertarCliente();
			comenzar();
			break;
			
		case 2:
			insertarTurismo();
			comenzar();
			break;
			
		case 3:
			insertarAlquiler();
			comenzar();
			break;
			
		case 4:
			buscarCliente();
			comenzar();
			break;
			
		case 5:
			buscarTurismo();
			comenzar();
			break;
			
		case 6:
			buscarAlquiler();
			comenzar();
			break;
		case 7:
			
			modificarCliente();
			comenzar();
			break;
		case 8:
			devolverAlquiler();
			comenzar();
			break;
			
		case 9:
			borrarCliente();
			comenzar();
			break;
			
		case 10:
			borrarTurismo();
			comenzar();
			break;
			
		case 11:
			borrarAlquiler();
			comenzar();
			break;
			
		case 12:
			listarClientes();
			comenzar();
			break;
			
		case 13:
			listarTurismos();
			comenzar();
			break;
		case 14:
			listarAlquileres();
			comenzar();
			break;
			
		case 15:
			listarAlquileresCliente();
			comenzar();
			break;
			
		case 16:
			listarAlquileresTurismo();
			comenzar();
			break;
		}
	}
	
	private void insertarCliente() {
		Consola.mostrarCabecera(Opcion.INSERTAR_CLIENTE.toString());
		
		try {
			controlador.insertar(Consola.leerCliente());
			System.out.println("EXITO: Se ha introducido exitosamente el cliente.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}
	
	private void insertarTurismo() {
		Consola.mostrarCabecera(Opcion.INSERTAR_TURISMO.toString());
		
		try {
			controlador.insertar(Consola.leerTurismo());
			System.out.println("EXITO: Se ha introducido exitosamente el turismo.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void insertarAlquiler() {
		Consola.mostrarCabecera(Opcion.INSERTAR_ALQUILER.toString());
		
		try {
			controlador.insertar(Consola.leerAlquiler());
			System.out.println("EXITO: Se ha introducido exitosamente el alquiler.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		} catch(DateTimeParseException e) {
			System.out.println("ERROR: El formato de la fecha introducida no es válida.");
			System.out.println("");
		}
	}

	private void buscarCliente() {
		Cliente cliente;
		Consola.mostrarCabecera(Opcion.BUSCAR_CLIENTE.toString());
		
		try {
			cliente = controlador.buscar(Consola.leerClienteDni());
			String mensaje = (cliente != null) ? cliente.toString() : "ERROR: No existe el cliente introducido.";
			System.out.println(mensaje);
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException| OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void buscarTurismo() {
		Turismo turismo;
		Consola.mostrarCabecera(Opcion.BUSCAR_TURISMO.toString());
		
		try {
			turismo = controlador.buscar(Consola.leerTurismoMatricula());
			String mensaje = (turismo != null) ? turismo.toString() : "ERROR: No existe el turismo introducido.";
			System.out.println(mensaje);
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void buscarAlquiler() {
		Alquiler alquiler;
		Consola.mostrarCabecera(Opcion.BUSCAR_ALQUILER.toString());
		
		try {
			alquiler = controlador.buscar(Consola.leerAlquiler());
			String mensaje = (alquiler != null) ? alquiler.toString() : "ERROR: No existe el alquiler introducido.";
			System.out.println(mensaje);
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		} catch(DateTimeParseException e) {
			System.out.println("ERROR: El formato de la fecha introducida no es válida.");
			System.out.println("");
		}
	}

	private void modificarCliente() {
		Consola.mostrarCabecera(Opcion.MODIFICAR_CLIENTE.toString());
		
		try {
			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.println("EXITO: Se ha modificado el cliente con exito.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void devolverAlquiler() {
		Consola.mostrarCabecera(Opcion.DEVOLVER_ALQUILER.toString());
		
		try {
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
			System.out.println("EXITO: Se ha devuelto el aquiler exitosamente.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		} catch(DateTimeParseException e) {
			System.out.println("ERROR: El formato de la fecha introducida no es válida.");
			System.out.println("");
		}
	}

	private void borrarCliente() {
		Consola.mostrarCabecera(Opcion.BORRAR_CLIENTE.toString());
		
		try {
			controlador.borrar(Consola.leerClienteDni());
			System.out.println("EXITO: Se ha borrado el cliente con exito.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void borrarTurismo() {
		Consola.mostrarCabecera(Opcion.BORRAR_TURISMO.toString());
		
		try {
			controlador.borrar(Consola.leerTurismoMatricula());
			System.out.println("EXITO: Se ha borrado el turismo con exito.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void borrarAlquiler() {
		Consola.mostrarCabecera(Opcion.BORRAR_ALQUILER.toString());
		
		try {
			controlador.borrar(Consola.leerAlquiler());
			System.out.println("EXITO: Se ha borrado el alquiler con exito.");
			System.out.println("");
		} catch(NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		} catch(DateTimeParseException e) {
			System.out.println("ERROR: El formato de la fecha introducida no es válida.");
			System.out.println("");
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera(Opcion.LISTAR_CLIENTES.toString());
		
		try {
			for(Cliente cliente : controlador.getClientes()) {
				System.out.println(cliente);
				System.out.println("");
			}
		} catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void listarTurismos() {
		Consola.mostrarCabecera(Opcion.LISTAR_TURISMOS.toString());
		
		try {
			for(Turismo turismo : controlador.getTurismos()) {
				System.out.println(turismo);
				System.out.println("");
			}
		} catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera(Opcion.LISTAR_ALQUILERES.toString());
		
		try {
			for(Alquiler alquiler : controlador.getAlquileres()) {
				System.out.println(alquiler);
				System.out.println("");
			}
		} catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera(Opcion.LISTAR_ALQUILERES_CLIENTE.toString());
		
		try {
			for(Alquiler alquilerClientes : controlador.getAlquileres(Consola.leerCliente())) {
				System.out.println(alquilerClientes);
				System.out.println("");
			}
		} catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera(Opcion.LISTAR_ALQUILERES_TURISMO.toString());
		
		try {
			for(Alquiler alquilerTurismos : controlador.getAlquileres(Consola.leerTurismo())) {
				System.out.println(alquilerTurismos);
				System.out.println("");
			}
		} catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}
}
