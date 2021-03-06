package com.ffm.persona.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffm.persona.mapper.PersonaMapper;
import com.ffm.persona.model.OutputConsultaPersonas;
import com.ffm.persona.model.OutputEliminaPersona;
import com.ffm.persona.model.Personas;

@Service
public class ServicePersona {

	OutputConsultaPersonas outputWs = new OutputConsultaPersonas();
	@Autowired
	PersonaMapper personaMapper;

	public Object getAll() {
		List<Personas> list = personaMapper.getAllPersonas();
		outputWs.setMensaje("Operacion correcta");
		outputWs.setDescripcion("Lista de personas");
		outputWs.setPersonas(list);
		return outputWs;
	}

	public Object getIdPersona(Integer idPersona) {
		List<Personas> list = personaMapper.getidPersonas(idPersona);
		outputWs.setMensaje("Operacion correcta");
		outputWs.setDescripcion("Lista de personas por id");
		outputWs.setPersonas(list);
		return outputWs;

	}

	public Object deletePersona(Integer idPersona) {
		OutputEliminaPersona outputdelete = new OutputEliminaPersona();
		personaMapper.deletePersona(idPersona);
		outputdelete.setMensaje("Operacion correcta");
		outputdelete.setDescripcion("Se borro correctamente a la Persona");
		return outputdelete;

	}

	public Object agregarPersona(Personas personas) {
		personaMapper.insertPersona(personas);
		List<Personas> list = personaMapper.getAllPersonas();
		outputWs.setMensaje("Operacion correcta");
		outputWs.setDescripcion("Se agrego correctamente a la persona");
		outputWs.setPersonas(list);
		return outputWs;
	}

	public Object actualizarPersonas(Integer idPersona, Personas personas) {
		OutputEliminaPersona outputdelete = new OutputEliminaPersona();
		personas.setIdPersona(idPersona);
		personaMapper.updatePersona(personas);
		outputdelete.setMensaje("Operacion correcta");
		outputdelete.setDescripcion("Se actualizo correcta la persona");
		return outputdelete;
	}

}
