package com.ffm.persona.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Personas {
	
	
	Integer idPersona;
	@ApiModelProperty(example = "Karla", name = "nombrePersona", notes = "Nombre de la persona que se creara", required = true)
	String nombrePersona;
	String apellidoPaterno;
	String apellidoMaterno;
	String telefonoCelular;
	String correoElectronico;
	String fechaRegistro;
	@ApiModelProperty(example = "1",  notes = "Determina si el registro esta visible o no valor 1= activo 0 = inactivo", required = true)
	String activo;

}
	