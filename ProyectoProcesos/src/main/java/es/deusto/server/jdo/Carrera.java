package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.Date;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
 @PersistenceCapable(detachable = "true")
public class Carrera implements Serializable{
	
	@PrimaryKey
	private String cod;
	private String nombreC;
	private String fecha;
	private String lugar;
	private double precio;
	private double premio;
	private static final long serialVersionUID = 1L;
	
	public Carrera(String cod, String nombreC, String fecha,  String lugar,  double precio,
			double premio) {
		super();
		this.cod = cod;
		this.nombreC = nombreC;
		this.fecha = fecha;
		this.lugar = lugar;
		this.precio = precio;
		this.premio = premio;
	}
	

	public String getCod() {
		return cod;
	}
	

	public void setCod(String cod) {
		this.cod = cod;
	}
	

	public String getNombreC() {
		return nombreC;
	}
	

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	
	public String getFecha() {
		return fecha;
	}
	

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	

	public String getLugar() {
		return lugar;
	}
	
	

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public double getPrecio() {
		return precio;
	}

	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public double getPremio() {
		return premio;
	}
	

	public void setPremio(double premio) {
		this.premio = premio;
	}

	
}
