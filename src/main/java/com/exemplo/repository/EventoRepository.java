package com.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.model.Evento;

@Repository //Define a classe como um bean do Spring
public interface EventoRepository extends JpaRepository<Evento, Integer>{

	Evento findOne(int codigo);

	void delete(int codigo);}
//Deve estender JpaRepository e declarar a entidade (Post) e o tipo de chave primária (Long)