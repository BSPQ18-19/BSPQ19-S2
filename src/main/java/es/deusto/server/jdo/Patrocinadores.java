package es.deusto.server.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Patrocinadores {

	@PrimaryKey
	private String codPatrocinador;
	private String nombre;
	private double contribucion;
	
	public Patrocinadores(String codPatrocinador, String nombre, double contribucion) {
		super();
		this.codPatrocinador = codPatrocinador;
		this.nombre = nombre;
		this.contribucion = contribucion;
	}

	public String getCodPatrocinador() {
		return codPatrocinador;
	}

	public void setCodPatrocinador(String codPatrocinador) {
		this.codPatrocinador = codPatrocinador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getContribucion() {
		return contribucion;
	}

	public void setContribucion(double contribucion) {
		this.contribucion = contribucion;
	}
	
	
}
