package br.com.gastronomia.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe modelo para o acesso ao banco de dados.
 * 
 * @author Luis Santana - luis.arseno@acad.pucrs.br
 * @since 11/08/2017
 * 
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "Ingrediente")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = -789863172532826108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdIngrediente")
	private long id;

	@Column(name = "Nome")
	private String nome;

	@Column(name= "Status")
	private boolean status;

	public Ingrediente() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ingrediente{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}