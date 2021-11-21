package com.unicap.engenhariadesoftware.chatbot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicap.engenhariadesoftware.chatbot.modelos.Direitos;
import com.unicap.engenhariadesoftware.chatbot.modelos.Jornada;
import com.unicap.engenhariadesoftware.chatbot.modelos.Requesitos;
import com.unicap.engenhariadesoftware.chatbot.modelos.TermoCompromisso;
import com.unicap.engenhariadesoftware.chatbot.repositorios.DireitosRepositorio;
import com.unicap.engenhariadesoftware.chatbot.repositorios.JornadaRepositorio;
import com.unicap.engenhariadesoftware.chatbot.repositorios.RequesitosRepositorio;
import com.unicap.engenhariadesoftware.chatbot.repositorios.TermoCompromissoRepositorio;

@RestController
@RequestMapping(value="/pr")
public class ControllerPerguntasRespostas {
	
	@Autowired
	DireitosRepositorio direitosRepositorio;
	
	@Autowired
	JornadaRepositorio jornadaRepositorio;
	
	@Autowired
	RequesitosRepositorio requesitosRepositorio;
	
	@Autowired
	TermoCompromissoRepositorio termoCompromissoRepositorio;
	
	
	@GetMapping("/direitos")
	public List<Direitos> listaDireito(){
		return direitosRepositorio.findAll();
	}
	@GetMapping("/jornada")
	public List<Jornada> listaJornada(){
		return jornadaRepositorio.findAll();
	}
	@GetMapping("/requesitos")
	public List<Requesitos> listaRequesitos(){
		return requesitosRepositorio.findAll();
	}
	@GetMapping("/termo")
	public List<TermoCompromisso> listaTermo(){
		return termoCompromissoRepositorio.findAll();
	}
	
	
	@PostMapping("/direitos")
	public Direitos adicionaDireitos(@RequestBody Direitos direito){
		direito.setModalidadeid(1);
		return direitosRepositorio.save(direito);
	}
	@PostMapping("/jornada")
	public Jornada adicionaJornada(@RequestBody Jornada jornada){
		jornada.setModalidadeid(2);
		return jornadaRepositorio.save(jornada);
	}
	@PostMapping("/requesitos")
	public Requesitos adicionaRequesitos(@RequestBody Requesitos requesitos){
		requesitos.setModalidadeid(3);
		return requesitosRepositorio.save(requesitos);
	}
	@PostMapping("/termo")
	public TermoCompromisso adicionaTermo(@RequestBody TermoCompromisso termoCompromisso){
		termoCompromisso.setModalidadeid(4);
		return termoCompromissoRepositorio.save(termoCompromisso);
	}

}
