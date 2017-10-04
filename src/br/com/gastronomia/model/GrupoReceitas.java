package br.com.gastronomia.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe modelo para o acesso ao banco de dados.
 * 
 * @author Luis Choma - luis.choma@acad.pucrs.br
 * @since 06/09/2017
 * 
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "GrupoReceita")
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedQuery(name="GrupoReceita.findNameUser", query="SELECT c FROM GrupoReceita g where c.usuario.nome like:"vname"")

public class GrupoReceitas implements Serializable {

	private static final long serialVersionUID = -789863172532826108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdGrupo")
	private long id;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "CustoPorcao")
	private double custo;

	@Column(name = "Status")
	private boolean status;

	private Usuario useuario;

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
	 *            Custo de uma por��o.
	 **/

	public GrupoReceitas(String nome, double custo) {
		this.nome = nome;
		this.custo = custo;
	}

	/**
	 * Valida se o grupo est� ativo ou n�o.
	 * 
	 * @return boolean
	 **/
	public boolean isActive() {
		return (this.status);
	}

	public long getId() {
		return id;
	}

	public void setId(long codGrupos) {
		this.id = codGrupos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getStatus() {
		return status;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GrupoReceitas [id=" + id + ", nome=" + nome + ", custo=" + custo + ", status=" + status
				+ "]";
	}
	
}