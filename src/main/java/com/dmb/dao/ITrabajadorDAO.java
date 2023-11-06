package com.dmb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dmb.entities.Trabajador;
import com.dmb.entities.Trabajo;

@Repository
public interface ITrabajadorDAO  extends JpaRepository<Trabajador,Long> {
	
	public List<Trabajador> findByTrabajo(Trabajo trabajo);
}
