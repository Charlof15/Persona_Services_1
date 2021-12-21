package com.ffm.persona.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ffm.persona.model.Personas;

@Mapper
public interface PersonaMapper {
	List<Personas> getAllPersonas();
	List<Personas> getidPersonas(Integer idPersona);
	void deletePersona(Integer idPersona);
	void insertPersona(Personas personas);
	void updatePersona(@Param("idPersona") Integer idPersona,@Param("nombrePersona")String nombrePersona,@Param("apellidoPaterno") String apellidoPaterno,@Param("apellidoMaterno") String apellidoMaterno,@Param("telefonoCelular") String telefonoCelular,@Param("correoElectronico") String correoElectronico);
	
}

