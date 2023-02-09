package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {

	private static final String ER_MARCA = "(Seat|Land Rover|KIA|Rolls-Royce|SsangYong)";
	private static final String ER_MATRICULA = "([1-9]{4}[B-Z^ÑQ]{3})";
	
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;
	
	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}
	
	public Turismo(Turismo turismo) {
		if(turismo == null)
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		
		setMarca(turismo.getMarca());
		setModelo(turismo.getModelo());
		setCilindrada(turismo.getCilindrada());
		setMatricula(turismo.getMatricula());
	}

	public static Turismo getTurismoConMatricula(String matricula) {
		Turismo turismoMatricula = new Turismo("Seat", "Panda", 4500, matricula);
		
		return turismoMatricula;
	}
	
	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		if(marca == null)
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		
		if(!marca.matches(ER_MARCA))
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	private void setModelo(String modelo) {
		if(modelo == null)
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		
		if(modelo.trim().isEmpty())
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if(cilindrada<=0 || cilindrada > 5000)
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		
		this.cilindrada = cilindrada;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		if(matricula == null)
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		
		if(!matricula.matches(ER_MATRICULA))
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return marca + " " + modelo + " (" + cilindrada + "CV) - " + matricula;
	}
}
