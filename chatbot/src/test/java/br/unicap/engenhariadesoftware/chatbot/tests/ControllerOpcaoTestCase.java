package br.unicap.engenhariadesoftware.chatbot.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;
import com.unicap.engenhariadesoftware.chatbot.modelos.Opcao;
import com.unicap.engenhariadesoftware.chatbot.repositorios.OpcaoRepositorio;
import com.unicap.engenhariadesoftware.chatbot.controllers.ControllerOpcao;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.PathVariable;

class ControllerOpcaoTestCase {
	
	private OpcaoRepositorio testRepository = mock(OpcaoRepositorio.class);
	ControllerOpcao controller = new ControllerOpcao(testRepository);

	@Test
	void verificaRetornoDasListas() {
		List<Opcao> lista = controller.listaOpcao();
		assertEquals("direto",lista.get(0));
	}
}
