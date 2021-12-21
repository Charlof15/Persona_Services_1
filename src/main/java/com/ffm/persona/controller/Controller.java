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

import io.swagger.annotations.ApiOperation;

@RestController
public class Controller {

	@Autowired
	private ServicePersona servicePersonas;

	@GetMapping(path = "/personas")
	@ApiOperation(value = "CONSULTAR TODAS LAS PERSONAS", notes = "Detalle de las personas registradas")
	public Object ObteniendoPersonas() {
		return servicePersonas.getAll();
	}

	@GetMapping(path = "/personas/idPersona/{idPersona}")
	@ApiOperation(value = "CONSULTAR TODAS LAS PERSONAS POR MEDIO DE ID", notes = "Es necesario el id para encontrar una persona")
	public Object busquedaPersonaPorId(@PathVariable(value = "idPersona") Integer idPersona) {
		return servicePersonas.getIdPersona(idPersona);
	}

	@DeleteMapping(path = "/personas/idPersona/{idPersona}")
	@ApiOperation(value = "ELIMINAR UNA PERSONA", notes = "Es necesario insertar un id para la eliminación de una persona")
	public Object eliminaPersona(@PathVariable(value = "idPersona") Integer idPersona) {
		try {
			return new ResponseEntity<>(servicePersonas.deletePersona(idPersona), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No funciona", e);
		}
	}

	@PostMapping(path = "/personas")
	@ApiOperation(value = "CREAR UNA PERSONA", notes = "Registrar una nueva persona")
	public Object creaPersona(@RequestBody Personas personas) {
		try {
			return new ResponseEntity<>(servicePersonas.agregarPersona(personas), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No funciona", e);
		}
	}

	@PatchMapping(path = "/personas/idPersona/{idPersona}")
	@ApiOperation(value = "ACTUALIZAR UN REGISTRO", notes = "Es necesario un id para la actualización del registro")
	public Object actualizaPersona(@PathVariable(value = "idPersona") Integer idPersona,
			@RequestBody Personas personas) {
		return servicePersonas.actualizarPersonas(idPersona, personas);
	}

}
