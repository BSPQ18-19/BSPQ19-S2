package es.deusto.server.jdo;

import java.util.Date;

public class Carrera {
	
	private String nombreC;
	private Date fecha;
	private String descripcion;
	private String lugar;
	private double duracion;
	private double precio;
	private double premio;
	
	public Carrera(String nombreC, Date fecha, String descripcion, String lugar, double duracion, double precio,
			double premio) {
		super();
		this.nombreC = nombreC;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.duracion = duracion;
		this.precio = precio;
		this.premio = premio;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
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
