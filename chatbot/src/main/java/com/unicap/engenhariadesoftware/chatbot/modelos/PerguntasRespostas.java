package com.unicap.engenhariadesoftware.chatbot.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERGUNTAS_RESPOSTAS_TB")
public class PerguntasRespostas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String modalidade;
	private String perguntas;
	private String respostas;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(String perguntas) {
		this.perguntas = perguntas;
	}
	public String getRespostas() {
		return respostas;
	}
	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
