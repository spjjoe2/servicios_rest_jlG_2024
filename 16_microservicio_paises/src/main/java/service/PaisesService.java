package service;

import java.util.List;

import entitie.Pais;

public interface PaisesService {
	List<String> continentes();
	List<Pais> paisesPorContinente(String continente);
}
