package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMOS("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar los alquileres de un cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar los alquileres de un turismo");
	
	private String texto;
	
	private Opcion(String texto) {
		this.texto = texto;
	}
	
	public Opcion get(int ordinal) {
		if(esOrdinalValido(ordinal))
			return values()[ordinal];
		
		throw new IllegalArgumentException("ERROR: Valor de la opción no válido.");
	}
	
	private boolean esOrdinalValido(int ordinal) {
		return ordinal >=0 && ordinal <= values().length - 1;
	}
	
	@Override
	public String toString() {
		return ordinal() + ". " + texto;
	}
}
