package com.ffm.persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ffm.persona.model.Personas;
import com.ffm.persona.service.ServicePersona;

@RestController
public class Controller {

	@Autowired
	private ServicePersona servicePersonas;

	@GetMapping(path = "/personas")
	public Object ObteniendoPersonas() {
		return servicePersonas.getAll();
	}

	@GetMapping(path = "/personas/idPersona/{idPersona}")
	public Object busquedaPersonaPorId(@PathVariable(value = "idPersona") Integer idPersona) {
		return servicePersonas.getIdPersona(idPersona);
	}

	@DeleteMapping(path = "/personas/idPersona/{idPersona}")
	public Object eliminaPersona(@PathVariable(value = "idPersona") Integer idPersona) {
		try {
			return new ResponseEntity<>(servicePersonas.deletePersona(idPersona), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No funciona", e);
		}
	}

	@PostMapping(path = "/personas")
	public Object creaPersona(@RequestBody Personas personas) {
		try {
			return new ResponseEntity<>(servicePersonas.agregarPersona(personas), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No funciona", e);
		}
	}

	@PatchMapping(path = "/personas/idPersona/{idPersona}")
	public Object actualizaPersona(@PathVariable(value = "idPersona")Integer idPersona, String nombrePersona, String apellidoPaterno, String apellidoMaterno,
			String telefonoCelular, String correoElectronico,@RequestBody Personas personas) {
		return servicePersonas.actualizarPersonas(idPersona, nombrePersona, apellidoPaterno, apellidoMaterno, telefonoCelular, correoElectronico);
	}

}
