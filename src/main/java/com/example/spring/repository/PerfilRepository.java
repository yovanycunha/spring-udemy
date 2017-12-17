package com.example.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String>{

	Perfil findByNome(String string);

}
