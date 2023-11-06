package com.dmb.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dmb.entities.Trabajador;
import com.dmb.entities.Trabajo;
import com.dmb.services.TrabajadorService;

@RestController
@RequestMapping("/api/v1")
public class TrabajadorController {

	@Autowired
	TrabajadorService trabajadorServ;

	@GetMapping("/trabajadores")
	public ResponseEntity<List<Trabajador>> listUsers() { 
		return ResponseEntity.ok(trabajadorServ.getAllTabajadores());
	}

	@GetMapping("/trabajador/{id}")
	public ResponseEntity<Trabajador> userById(@PathVariable(name = "id") Long id) {
		Optional<Trabajador> trabajador = trabajadorServ.getTrabajador(id);
		if (trabajador.isPresent()) {
			return ResponseEntity.ok(trabajador.get());
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}

	@PostMapping("/trabajador")
	public ResponseEntity<Long> createUser(@RequestBody Trabajador trabajador) {
		
		trabajadorServ.saveTrabajador(trabajador);
		return ResponseEntity.status(HttpStatus.CREATED).body(trabajador.getId()); // Status 201, solo el ID por seguridad
	}

	@PutMapping("/trabajador/{id}")
	public ResponseEntity<Trabajador> updateUser(@PathVariable(name = "id") Long id,
			
			@RequestBody Trabajador updatedTrabajador) {
		
		Optional<Trabajador> trabajador = trabajadorServ.getTrabajador(id);
		
		if (trabajador.isPresent()) {
			
			Trabajador existingTrabajador = trabajador.get();
			existingTrabajador.setNombre(updatedTrabajador.getNombre());
			existingTrabajador.setApellido(updatedTrabajador.getApellido());
			existingTrabajador.setDni(updatedTrabajador.getDni());
			existingTrabajador.setTrabajo(updatedTrabajador.getTrabajo());
			trabajadorServ.saveTrabajador(existingTrabajador);
			return ResponseEntity.ok(existingTrabajador); 
			
		} else {
			
			return ResponseEntity.notFound().build(); 
		}
	}

	@DeleteMapping("/trabajador/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
		Optional<Trabajador> trabajador = trabajadorServ.getTrabajador(id);
		if (trabajador.isPresent()) {
			trabajadorServ.deleteTrabajor(id);
			return ResponseEntity.noContent().build(); // Status 204
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@GetMapping("/trabajadores/{trabajo}")
	public ResponseEntity<List<Trabajador>> listarTrabajo(@PathVariable(name="trabajo") String trabajoStr) {
	    Trabajo trabajo = Trabajo.valueOf(trabajoStr.toUpperCase());
	    return ResponseEntity.ok(trabajadorServ.getAllTrabajadorByTrabajo(trabajo));
	}

}
