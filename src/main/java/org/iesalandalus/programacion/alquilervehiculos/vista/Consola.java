package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);
	
	private Consola() {
		
	}

	public static void mostrarMenu() {
		 System.out.println("MENÚ DEL PROGRAMA");
		 System.out.println("-----------------");
		 
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
		System.out.println("");
	}
	
	public static void mostrarCabecera(String mensaje) {
		int longitud = mensaje.length();
		
		System.out.println(mensaje);
		for(int i = 0; i < longitud; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}

	private static String leerCadena(String mensaje) {
		System.out.print(mensaje);
		String cadena = Entrada.cadena();
		
		return cadena;
	}

	private static Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		int entero = Entrada.entero();
		
		return entero;
	}

	private static LocalDate leerFecha(String mensaje) {
		LocalDate fecha = null;
		
		do {
		System.out.print(mensaje);
		fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		}while(fecha == null);

		return fecha;
	}

	public static Opcion elegirOpcion() {
		int opcionElegida=0;
		Opcion[] opcion=Opcion.values();
		
		do{
			opcionElegida = leerEntero("Introduce la opción a realizar (0-16): ");
		}while (opcionElegida<0 || opcionElegida>16);
		
		return opcion[opcionElegida];
	}

	public static Cliente leerCliente() {
		String nombre = leerCadena("Introduzca el nombre del cliente: ");
		String dni = leerCadena("Introduzca el dni del cliente: ");
		String telefono = leerCadena("Introduzca el telefono del teléfono: ");
		return new Cliente(nombre, dni, telefono);
	}

	public static Cliente leerClienteDni() {
		String dni = leerCadena("Introduzca el dni del cliente a buscar: ");
		return Cliente.getClienteConDni(dni);
	}

	public static String leerNombre() {
		String nombre = leerCadena("Introduzca el nombre del cliente: ");
		return nombre;
	}

	public static String leerTelefono() {
		String telefono = leerCadena("Introduzca el teléfono del cliente: ");
		return telefono;
	}

	public static Turismo leerTurismo() {
		String marca = leerCadena("Introduzca la marca del turismo: ");
		String modelo = leerCadena("Introduzca el módelo del turismo: ");
		int cilindrada = leerEntero("Indroduzca la cilindrada del turismo: ");
		String matricula = leerCadena("Introduzca la matrícula del turismo: ");
		return new Turismo(marca, modelo, cilindrada, matricula);
	}

	public static Turismo leerTurismoMatricula() {
		String matricula = leerCadena("Introduzca la matrícula a buscar: ");
		return Turismo.getTurismoConMatricula(matricula);
	}

	public static Alquiler leerAlquiler() {
		Cliente cliente = leerCliente();
		Turismo turismo = leerTurismo();
		
		LocalDate fechaAlquiler = leerFecha("Introduzca la fecha de alquiler: ");
		
		return new Alquiler(cliente, turismo, fechaAlquiler);
	}

	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion = leerFecha("Introduzca la fecha de devolución: ");
		
		return fechaDevolucion;
	}
}

