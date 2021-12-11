package br.unicap.engenhariadesoftware.chatbot.tests;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unicap.engenhariadesoftware.chatbot.ChatbotApplication;
import com.unicap.engenhariadesoftware.chatbot.controllers.ControllerOpcao;
import com.unicap.engenhariadesoftware.chatbot.modelos.Opcao;
import com.unicap.engenhariadesoftware.chatbot.repositorios.OpcaoRepositorio;

import static org.mockito.Mockito.mock;

import java.util.List;

@SpringBootTest(classes=ChatbotApplication.class)
class ControllerOpcaoTestCase {
	
	@Autowired
	ControllerOpcao controller;
	
	@Test
	void verificaRetornoDasListas() {
		List<Opcao> lista = controller.listaOpcao();
	}
	
}
