package com.persona.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persona.modelo.Persona;

/*
 * ORG: ORGANIZACION (INTERNO)
 * COM: COMERCIAL (VENDER)
 * 
 * LA INTERFAZ NO SE PROGRAMA, SOLO SE AGREGAN LOS METOODS A IMPLEMENTAR
 * 
 * test => ID (int)
 */

@Repository
public interface IPersonaDao extends CrudRepository<Persona, Serializable>{

	/*
	 * NO SE PROGRAMA EL CRUD PORQUE YA EXISTEN LOS METODOS:
	 * save, delete, deleteAll, deleteById, update
	 */
	
	
	
}
