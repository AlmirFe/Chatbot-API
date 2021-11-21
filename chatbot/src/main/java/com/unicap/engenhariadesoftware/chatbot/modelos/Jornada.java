package com.unicap.engenhariadesoftware.chatbot.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "JORNADA_TB")
public class Jornada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String pergunta;
	private String resposta;
	private long modalidadeid;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public long getModalidadeid() {
		return modalidadeid;
	}
	public void setModalidadeid(long modalidadeid) {
		this.modalidadeid = modalidadeid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 

}
