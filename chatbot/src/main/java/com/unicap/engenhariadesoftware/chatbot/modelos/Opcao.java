package com.unicap.engenhariadesoftware.chatbot.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_OPCAO")
public class Opcao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	private String opcao;
	private long id_tabela;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	public long getId_tabela() {
		return id_tabela;
	}
	public void setId_tabela(long id_tabela) {
		this.id_tabela = id_tabela;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
	

}
