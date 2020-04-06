package com.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.exemplo.exemplospring.EventoServico;
import com.exemplo.model.Evento;

@Controller //Define a classe como um bean do Spring
public class EventoController {
	
   @Autowired
   private EventoServico service; // Injeta a classe serviços
   
   
   @GetMapping("/evento")
   
   public ModelAndView findAll() {
	  ModelAndView mv = new ModelAndView("/evento"); 
      
	  mv.addObject("eventos", service.findAll());
   
	  
	  return mv;
   }
   
   // vai para teça de adição dos eventos
   
   @GetMapping("/evento/add")
   public ModelAndView add(Evento evento) {
	  
	 ModelAndView mv = new ModelAndView("/eventoAdd");
	 mv.addObject("eventos", evento);
	 return mv;
   }

   // vai para a tela de edição de posts (mesma tela de adição, é enviado para a view um objeto que já existe)
   
    @GetMapping("/evento/edit/{codigo}")
    
    public ModelAndView edit(@PathVariable("codigo") int codigo) {
    	return add(service.findOne(codigo));
    }
    
    //Exclui um post por seu ID e redireciona para a tela principal



	@GetMapping("/encomenda/delete/{codigo}")
    public ModelAndView delete(@PathVariable("codigo") int codigo) {
    	
    	service.delete(codigo);
    	return findAll();
    }
}
