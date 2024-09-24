package utilities;

import org.springframework.stereotype.Component;

import entities.Hotel;
import entities.Reserva;
import entities.Vuelo;
import model.HotelDto;
import model.ReservaDto;
import model.VueloDto;

@Component
	public class Mapeador {
		
		
		public HotelDto hotelToDto(Hotel hotel) {
			return new HotelDto(hotel.getIdHotel(),
					hotel.getNombre(),
					hotel.getCategoria(),
					hotel.getPrecio(),
					hotel.isDisponible(),
					hotel.getLocalizacion());
		}
		public Hotel dtoToHotel(HotelDto hotel) {
			return new Hotel(hotel.getIdHotel(),
					hotel.getNombre(),
					hotel.getCategoria(),
					hotel.getPrecio(),
					hotel.isDisponible(),
					hotel.getLocalizacion());
		}
		public VueloDto vueloToDto(Vuelo vuelo) {
			return new VueloDto(vuelo.getIdVuelo(),
					vuelo.getCompany(),
					vuelo.getFecha(),
					vuelo.getPrecio(),
					vuelo.getPlazas(),
					vuelo.getDestino());
		}
		public Vuelo dtoToVuelo(VueloDto vuelo) {
			return new Vuelo(vuelo.getIdVuelo(),
					vuelo.getCompany(),
					vuelo.getFecha(),
					vuelo.getPrecio(),
					vuelo.getPlazas(),
					vuelo.getDestino());
		}
		public ReservaDto reservaToDto(Reserva reserva) {
			return new ReservaDto(reserva.getIdReserva(),reserva.getUsuario(),
					vueloToDto(reserva.getVuelo()),
					hotelToDto(reserva.getHotel()),
					reserva.getPrecio());
		}
		public Reserva dtoToReserva(ReservaDto reserva) {
			return new Reserva(reserva.getIdReserva(),reserva.getUsuario(),
					dtoToVuelo(reserva.getVueloDto()),
					dtoToHotel(reserva.getHotelDto()),
					reserva.getPrecio());
		}
	} 


