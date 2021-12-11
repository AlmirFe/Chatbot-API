package br.unicap.engenhariadesoftware.chatbot.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unicap.engenhariadesoftware.chatbot.ChatbotApplication;
import com.unicap.engenhariadesoftware.chatbot.controllers.ControllerOpcao;
import com.unicap.engenhariadesoftware.chatbot.modelos.Opcao;


import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest(classes=ChatbotApplication.class)
class ControllerOpcaoTestCase {
	

	@Autowired
	ControllerOpcao controller;
	String[] nomes = {"Direitos", "Jornada", "Termo", "Requisitos"};
	
	/*Esse teste testa as consistencia das devoluções do metodo
	 *listaOpcao() da classe ControllerOpcao().
	 *Nesse teste é feita a chamada da função armazenando seu
	 *retorno. Verificasse se o retorno não é nulo depois valida o
	 *conteúdo da lista retornada*/
	
	@Test
	void verificaRetornoDeListaOpcao() {
		List<Opcao> lista = controller.listaOpcao();
		assertNotNull(lista);
	}
	
	
	/*Esse teste valida o conteúdo da lista retornada
	 * valiando se os objetos são nulos, seus nomes e ids.*/

	@Test
	void verificaIntegridadeDeListaOpcao() {
		List<Opcao> lista = controller.listaOpcao();
		long i = 0;
		for(Opcao opcao : lista) {
			assertNotNull(opcao);
			
			String nomeOpcao = opcao.getNome();
			long idOpcao = opcao.getId();
			assertEquals(nomes[(int) i], nomeOpcao);
			assertEquals(i+1, idOpcao);
			
			i++;
		}
	}
	
	/*Valida o retorno da função mostraOpcao()
	 * da classe ControllerOpcao fazendo a chamda da funcão
	 * e validade se o objeto retornado não é nulo.*/
	@Test
	void verificaRetornoDeMostraOpcao() {
			Opcao opcao = controller.mostraOpcao(1);
			assertNotNull(opcao);
	}
	
	/*Esse teste valida o conteúdo das opções
	 * rertornadas pela funcão mostraOpcao() 
	 * comparando o conteúdo com dados
	 * já conhecidos dos nomes e ids das opções*/
	@Test
	void verificaIntegridadeDeMostraOpcao() {
		long[] ids = {1, 2 ,3, 4 };
		
		for(long id : ids) {
			Opcao opcao = controller.mostraOpcao(id);			
			String nomeOpcao = opcao.getNome();
			long idOpcao = opcao.getId();
			assertEquals(nomes[(int)(id - 1)], nomeOpcao);
			assertEquals(id, idOpcao);
		}		
	}
	
	/*Esse test valida se a função adicionaOpção() 
	 * de fato adiciona novas opções com o conteúdo
	 * previamente estabelecido, verificando se o retorno
	 * da função é a propria opção enviada e chamando a função
	 * mostraOpcao para ver se a opção retorna com esperado.*/
	@Test
	void verificaIntegridadeAdicionaOpcao() {
		long id = 5;
		String nome = "Opcao Teste";
		Opcao novaOpcao = new Opcao();
		
		novaOpcao.setId(id);
		novaOpcao.setNome(nome);
		
		Opcao retorno = controller.adicionaOpcao(novaOpcao);
		assertNotNull(retorno);
		
		retorno = controller.mostraOpcao(id);
		assertNotNull(retorno);
		controller.apagaOpcao(retorno);
	}
	
	/*Valida o conteúdo de uma opção adicionada
	 * pela função adicionaOpcao() da classe ControlllerOpcao
	 * adicionando a opção e buscando-a no banco de dados
	 * e validando os dados do retorno com dados previamente
	 * determinados.*/	
	@Test
	void validaConteudoOpcaoAdicinadaPorAdicionaOpcao() {
		long id = 5;
		String nome = "Opcao Teste";
		Opcao novaOpcao = new Opcao();
		
		novaOpcao.setId(id);
		novaOpcao.setNome(nome);
		
		controller.adicionaOpcao(novaOpcao);		
		Opcao retorno = controller.mostraOpcao(id);
		
		String nomeOpcao = retorno.getNome();
		long idOpcao = retorno.getId();
		assertEquals(nome, nomeOpcao);
		assertEquals(id, idOpcao);
		
		controller.apagaOpcao(retorno);
	}	
}
