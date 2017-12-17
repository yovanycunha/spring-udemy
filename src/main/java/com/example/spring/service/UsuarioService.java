package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Usuario;
import com.example.spring.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listaUsuario() {

		return this.usuarioRepository.findAll();

	}

	public Page<Usuario> listaPaginada(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return this.usuarioRepository.findAll(pages);
	}
	
	
	public List<Usuario> buscaPorNome(String nome){
		return this.usuarioRepository.findByNomeLikeIgnoreCase(nome);
	}
	
	public Usuario consultarUsuario(String id) {
		
		return this.usuarioRepository.findOne(id);
	}
	
	public Usuario salvarUsuario(Usuario novoUsuario) {

		return this.usuarioRepository.save(novoUsuario);

	}
	
	
	public void apagarUsuario(String id) {
		
		this.usuarioRepository.delete(id);
		
	}
	
	public Usuario getById(String id) {
		return this.usuarioRepository.findOne(id);
	}

}
