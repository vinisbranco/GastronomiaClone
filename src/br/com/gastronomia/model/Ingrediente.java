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
	private long cod_ingrediente;

	@Column(name = "Nome", unique = true)
	private String nome;

	@Column(name= "Status")
	private String status;


	public Ingrediente() {

	}

	public long getCod_ingrediente() {
		return cod_ingrediente;
	}

	public void setCod_ingrediente(long cod_ingrediente) {
		this.cod_ingrediente = cod_ingrediente;
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

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ingrediente{" +
				"cod_ingrediente=" + cod_ingrediente +
				", nome='" + nome + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}