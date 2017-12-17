package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Perfil;
import com.example.spring.service.PerfilService;

@RestController
public class PerfilController {
	
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public List<Perfil> listar(){
		
		return this.perfilService.listaPerfil();
		
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public Perfil getById(@PathVariable String id) {
		return this.perfilService.getById(id);
	}
	
	@RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
	public Page<Perfil> listaPaginada(@PathVariable int page, @PathVariable int count) {
		return this.perfilService.listaPaginada(page, count);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public Perfil salvar(@RequestBody Perfil perfil) {
		return this.perfilService.salvarPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.PUT)
	public Perfil editar(@RequestBody Perfil perfil) {
		return this.perfilService.salvarPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public void apagarUsuario(@PathVariable String id) {
		this.perfilService.deletePerfil(id);
	}
	
}
