package com.example.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	List<Usuario> findByNomeLikeIgnoreCase(String nome);

	Usuario findByEmail(String userName);

}
