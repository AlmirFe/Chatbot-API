package com.unicap.engenhariadesoftware.chatbot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicap.engenhariadesoftware.chatbot.modelos.Opcao;
import com.unicap.engenhariadesoftware.chatbot.repositorios.OpcaoRepositorio;

@RestController
@RequestMapping(value="/chatbot")
public class ControllerOpcao {

	@Autowired
	OpcaoRepositorio opcaoRepositorio;
	
	@GetMapping("/opcoes")
	public List<Opcao> listaOpcao(){
		return opcaoRepositorio.findAll();
	}
	@GetMapping("/opcao/{id}")
	public Opcao mostraOpcao(@PathVariable(value="id") long id){
		return opcaoRepositorio.findById(id);
	}
}
