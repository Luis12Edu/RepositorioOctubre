package com.persona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.persona.modelo.Persona;
import com.persona.service.IPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * MODEL: TIPO DE COLLLECTION, PARA GUARDAR ONJETOS O LISTAS
 * @GetMapping: RECURSO HTTP, PARA MANDAR A LLAMAR LAS URL
 * 
 * http://localhost:7575/listar
 * http://localhost:7575/save
 * http://localhost:7575/eliminar
 * 
 * @PostMapping: ENVIAR LOS RECURSOS, A LA ENTIDAD
 * 
 * @PostVariable: RECUPERA EL VALOR DE UNA VARIABLE EN MEMORIA
 * 
 * 
 */



@Controller
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping("/listar")
	public String listarPersona(Model model) {
		List<Persona> personas = service.listPersona();
		model.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String guardarPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@PostMapping("/save")
	public String savePersona (Persona persona) {
		service.savePersona(persona);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editarPersona(@PathVariable int id, Model model) {
		Optional<Persona> persona = service.getPersonaById(id);
		model.addAttribute("persona",persona);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPersona(@PathVariable int id) {
		service.deletePersona(id);
		return "redirect:/listar";
	}
	
	
}
