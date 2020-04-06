package com.exemplo.exemplospring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.model.Evento;
import com.exemplo.repository.EventoRepository;

@Service //Define a classe como um bean do Spring
public class EventoServico {

    @Autowired
	
    private EventoRepository repository; //Injeta o repositório
    
  //Retorna uma lista com todos posts inseridos
	public List<Evento> findAll() { return repository.findAll(); }
	
	// Retorna um post a partir do ID 
	public Evento findOne(int codigo) { return repository.findOne(codigo);}
	
	//Salva ou atualiza um post
	public Evento save(Evento evento) {
		return repository.saveAndFlush(evento);
	}
	
	//Exclui um post
	public void delete(int codigo) {
		repository.delete(codigo);
	}
	
}
