package br.unicap.engenhariadesoftware.chatbot.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unicap.engenhariadesoftware.chatbot.ChatbotApplication;
import com.unicap.engenhariadesoftware.chatbot.controllers.ControllerPerguntasRespostas;
import com.unicap.engenhariadesoftware.chatbot.modelos.PerguntasRespostas;


@SpringBootTest(classes=ChatbotApplication.class)
class ControllerPerguntasRespostasTestCase {
	
	@Autowired
	ControllerPerguntasRespostas cpr;
	
	
	@Test
	void caseAdicionarNull() {//nesse teste, o intuito é que retorne nulo ao tentar adicionar em uma modalidade inexistente
		PerguntasRespostas  result;
		result =  cpr.adicionaPergunta(new PerguntasRespostas(),-1);
		assertEquals(null, result);
	}
	
	@Test
	void caseListarNotNull() {//nesse teste, o objetivo é que não retorne nulo ao tentar listar a modalidade de id 1
		List<PerguntasRespostas>  lpr;
		lpr =  cpr.listaPerguntaModalidade(1);
		assertNotEquals(null, lpr);
	}
	
	@Test
	void caseListarNull() {//nesse teste, o intuito é que retone nulo ao tentar pegar uma modalidade que não existe
		List<PerguntasRespostas>  lpr;
		lpr =  cpr.listaPerguntaModalidade(-1);
		assertEquals(null, lpr);
	}
	
	@Test
	void caseBuscarModalidadeNull() {//nesse teste, o intuito é que não retorne nulo ao procurar uma pergunta na posição 1
		long modalidade = 1;
		int pergunta = 1;
		PerguntasRespostas  result;
		result = cpr.retornaPergunta(modalidade,pergunta);
		assertNotEquals(null, result);
	}
	
}
