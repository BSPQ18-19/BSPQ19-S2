package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 @PersistenceCapable
public class Carrera implements Serializable{
	
	@PrimaryKey
	private String cod;
	private String nombreC;
	private String fecha;
	private String lugar;
	private double precio;
	private double premio;
	@Join
	@Persistent(defaultFetchGroup="true")
	private ArrayList <Usuario> listaUsuarios;
	@Persistent(defaultFetchGroup="true")
	private Patrocinadores patrocinador;
	
	
	//private static final long serialVersionUID = 1L;
	
	//Constructores
	
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
	
	//getters y setters cod
	

	public String getCod() {
		return cod;
	}
	

	public void setCod(String cod) {
		this.cod = cod;
	}
	
	//getters y setters Nombre

	public String getNombreC() {
		return nombreC;
	}
	

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	
	//getters y setters Fecha

	
	public String getFecha() {
		return fecha;
	}
	

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	//getters y setters Lugar

	

	public String getLugar() {
		return lugar;
	}
	
	

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
	//getters y setters precio


	public double getPrecio() {
		return precio;
	}

	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//getters y setters premio

	
	public double getPremio() {
		return premio;
	}
	

	public void setPremio(double premio) {
		this.premio = premio;
	}

	
}
