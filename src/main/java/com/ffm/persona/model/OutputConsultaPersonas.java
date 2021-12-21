package com.ffm.persona.model;

import java.util.List;

public class OutputConsultaPersonas {

	private String mensaje;
	private String descripcion;
	private List<Personas> personas;
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Personas> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Personas> personas) {
		this.personas = personas;
	}
}
