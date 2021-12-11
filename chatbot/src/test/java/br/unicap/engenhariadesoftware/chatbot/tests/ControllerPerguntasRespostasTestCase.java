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
	void caseListarNotNull() {
		List<PerguntasRespostas>  lpr;
		lpr =  cpr.listaPerguntaModalidade(1);
		assertNotEquals(null, lpr);
	}
	
	@Test
	void caseListarNull() {
		List<PerguntasRespostas>  lpr;
		lpr =  cpr.listaPerguntaModalidade(-1);
		assertEquals(null, lpr);
	}
	
	@Test
	void caseBuscarModalidadeNull() {//nesse teste, o intuito é que retorne nulo ao tentar adicionar em uma modalidade inexistente
		long modalidade = 1;
		int pergunta = 1;
		PerguntasRespostas  result;
		result = cpr.retornaPergunta(modalidade,pergunta);
		assertEquals(null, result);
	}
	
}
