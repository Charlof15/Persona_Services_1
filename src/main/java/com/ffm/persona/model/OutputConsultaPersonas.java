package com.ffm.persona.model;
import java.util.List;

import lombok.Data;

@Data
public class OutputConsultaPersonas {
	private String mensaje;
	private String descripcion;
	private List<Personas> personas;	
}
