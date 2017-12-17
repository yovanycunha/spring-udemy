package com.example.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Usuario;

@RestController
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getTexto() {
		return "Disgraaaaaaça";
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Usuario getTexto(@PathVariable String name) {
		Usuario usuario = new Usuario();
		usuario.setNome(name);
		return usuario;
	}
	
}
