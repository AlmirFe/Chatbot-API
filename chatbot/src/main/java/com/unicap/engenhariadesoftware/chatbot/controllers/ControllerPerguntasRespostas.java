package com.unicap.engenhariadesoftware.chatbot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicap.engenhariadesoftware.chatbot.repositorios.OpcaoRepositorio;
import com.unicap.engenhariadesoftware.chatbot.repositorios.PerguntasRespostasRepositorio;
import com.unicap.engenhariadesoftware.chatbot.modelos.Opcao;
import com.unicap.engenhariadesoftware.chatbot.modelos.PerguntasRespostas;

@RestController
@RequestMapping(value="/qa")
public class ControllerPerguntasRespostas {
	
	@Autowired
	PerguntasRespostasRepositorio PR;
	@Autowired
	OpcaoRepositorio opcoesRepositorio;
	
	@PostMapping("/pergunta/{id}")
	public PerguntasRespostas adicionaPergunta(@RequestBody PerguntasRespostas pergunta, @PathVariable(value="id") long id) {
		
		Opcao opcao = opcoesRepositorio.findById(id); 
		
		if(opcao != null) {
			
			pergunta.setModalidade(opcao.getNome());
			opcao.setModalidade(pergunta); 
			return PR.save(pergunta);
		}else {
			
			return null;
		}
	}
	@GetMapping("/perguntas/{id}")
	public List<PerguntasRespostas> listaPerguntaModalidade(@PathVariable(value="id") long id){
		
		Opcao opcao = opcoesRepositorio.findById(id);
		
		if(opcao != null) {
			
			return opcao.getModalidade();
		}else {
			
			return null;
		}
		
	}
	@GetMapping("/pergunta/{modalidade_id}/{pergunta_id}")
	public PerguntasRespostas retornaPergunta(@PathVariable(value="modalidade_id") long modalidade, @PathVariable(value="pergunta_id") int id) {
		return opcoesRepositorio.findById(modalidade).getModalidade().get(id-1);
	}
	
	

}
