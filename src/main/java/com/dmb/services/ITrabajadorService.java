package com.dmb.services;

import java.util.List;
import java.util.Optional;
import com.dmb.entities.Trabajador;
import com.dmb.entities.Trabajo;

public interface ITrabajadorService {

	public List<Trabajador> getAllTabajadores();
	
	public Optional<Trabajador> getTrabajador(Long id);

	public Trabajador saveTrabajador(Trabajador dao);

	public Trabajador editTrabajador(Trabajador dao);

	public void deleteTrabajor(Long id);
	
	public List<Trabajador> getAllTrabajadorByTrabajo(Trabajo trabajo);

}
