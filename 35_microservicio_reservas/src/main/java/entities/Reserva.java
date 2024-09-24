package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
 
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel", referencedColumnName = "idHotel")
	private Hotel hotel;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vuelo", referencedColumnName = "idvuelo")
	private Vuelo vuelo;
	
	private double precio;
	private String usuario;
 
	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reserva(int idReserva,String usuario, Vuelo vuelo,Hotel hotel,double precio) {
		super();
		this.idReserva = idReserva;
		this.usuario = usuario;
		this.vuelo = vuelo;	 
		this.precio = precio;
	}

 
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
 
}
