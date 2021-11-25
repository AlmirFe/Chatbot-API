package com.unicap.engenhariadesoftware.chatbot.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="OPCAO_TB")
public class Opcao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id; 
	private String nome;
	@OneToMany
	private List<PerguntasRespostas> modalidade;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<PerguntasRespostas> getModalidade() {
		return modalidade;
	}
	public void setModalidade(PerguntasRespostas pergunta) {
		modalidade.add(pergunta);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
