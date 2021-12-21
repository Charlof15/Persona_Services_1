package com.ffm.persona.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ffm.persona.model.Personas;

@Mapper
public interface PersonaMapper {
	List<Personas> getAllPersonas();
	List<Personas> getidPersonas(Integer idPersona);
	void deletePersona(Integer idPersona);
	void insertPersona(Personas personas);
	void updatePersona(Personas personas);

}
