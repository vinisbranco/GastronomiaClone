package br.com.gastronomia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.validation.constraints.Email;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Classe modelo para Atributo.
 * 
 * @author Eduardo José Silva (eduardo.silva.006@acad.pucrs.br), baseado no modelo de Rodrigo Machado (rodrigo.domingos@acad.pucrs.br) para cadastro de usuário
 * @since 07/9/2017
 * 
 **/

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "ATRIBUTO")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Atributo implements Serializable {

	private static final long serialVersionUID = -789863172532826108L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ATRIBUTO")
	private long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "UNIDADE")
	private String unidade;
	
	@Column(name = "MULTIPLICADOR")
	private long multiplicador;
	
	@Column(name= "STATUS")
	private String status;

	/**
	 * Construtor vazio.
	 * 
	 **/
	public Atributo() {
		
	}

	public Atributo(String nome, long multiplicador) {
		this.nome = nome;
		this.multiplicador = multiplicador;
		this.unidade = "g";				
	}
	
	public long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public String getStatus() {
		return status;
	}
	
	public long getMultiplicador() {
		return multiplicador;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMultiplicador(long multiplicador) {
		this.multiplicador = multiplicador;
	}
	
	public void setStatus(String status) {
		if(status.equals("ativo") || status.equals("inativo"))
			this.status = status;
	}

	/**
	 * Valida se o usuario esta ativo ou nao.
	 * 
	 * @return String
	 **/
	public String isActive() {
		return status;
	}
	
	@Override
	public String toString() {
		return "Atributo " + nome + " ID: " + id + " unidade: " + unidade 
				+ " multiplicador: " + multiplicador + " status:" + status;
	}
}