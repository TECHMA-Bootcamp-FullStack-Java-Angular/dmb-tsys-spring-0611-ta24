package com.dmb.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.dao.ITrabajadorDAO;
import com.dmb.entities.Trabajador;
import com.dmb.entities.Trabajo;

@Service
public class TrabajadorService implements ITrabajadorService{
	
	@Autowired
	private ITrabajadorDAO dao;
	
	@Override
	public List<Trabajador> getAllTabajadores() {
		return dao.findAll();
	}

	@Override
	public Optional<Trabajador> getTrabajador(Long id) {	
		return dao.findById(id);
	}

	@Override
	public Trabajador saveTrabajador(Trabajador entity) {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Trabajador editTrabajador(Trabajador entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteTrabajor(Long id) {
		dao.deleteById(id);;	
	}

	@Override
	public List<Trabajador> getAllTrabajadorByTrabajo(Trabajo trabajo) {
		return dao.findByTrabajo(trabajo);
	}




}
