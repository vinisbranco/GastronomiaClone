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
 * Classe modelo para o acesso ao banco de dados.
 * 
 * @author Luis Choma - luis.choma@acad.pucrs.br
 * @since 06/09/2017
 * 
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "GRUPOS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrupoReceitas implements Serializable {

	private static final long serialVersionUID = -789863172532826108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_GRUPOS")
	private long codGrupos;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CUSTO_PORCAO")
	private double custo;

	@Column(name = "STATUS")
	private String status;

	/**
	 * Construtor vazio.
	 * 
	 **/
	public GrupoReceitas() {
	}

	/**
	 * Construtor com nome.
	 * 
	 * @param nome
	 *            Nome de um usuario.
	 **/
	public GrupoReceitas(String nome) {
		this.nome = nome;
	}

	/**
	 * Construtor com nome e custo.
	 * 
	 * @param nome
	 *            Nome de um usuario.
	 * @param custo
	 *            Custo de uma porção.
	 **/

	public GrupoReceitas(String nome, double custo) {
		this.nome = nome;
		this.custo = custo;
	}

	/**
	 * Valida se o grupo está ativo ou não.
	 * 
	 * @return boolean
	 **/
	public boolean isActive() {
		return (this.status.equals("Ativo"));
	}

	public long getCodGrupos() {
		return codGrupos;
	}

	public void setCodGrupos(long codGrupos) {
		this.codGrupos = codGrupos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GrupoReceitas [codGrupos=" + codGrupos + ", nome=" + nome + ", custo=" + custo + ", status=" + status
				+ "]";
	}
	
}