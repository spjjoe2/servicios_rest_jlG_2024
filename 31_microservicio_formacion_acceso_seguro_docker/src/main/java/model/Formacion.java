package model;

public class Formacion {
	private String nombre;
	private String area;
	private double duracion;
	private double precio;
	public Formacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Formacion(String nombre, String area, double duracion, double precio) {
		super();
		this.nombre = nombre;
		this.area = area;
		this.duracion = duracion;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	
	

}
