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
 * Feito a partir da classe User do projeto IdeiasAges
 * 
 * @author Pedro Bledow - pedro.bledow@acad.pucrs.br
 * @since 06/09/2017
 * 
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "Users")
@JsonIgnoreProperties(ignoreUnknown=true)
public class User implements Serializable {

	private static final long serialVersionUID = -789863172532826108L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdUsuario")
	private long id;
	
	@Column(name = "Cpf", unique = true)
	private String cpf;
	
	@Email(message="E-mail invalido")
	@Column(name = "Email", unique = true)
	private String email;
	
	@Column(name = "Matricula", unique = true)
	private String matricula;
	
	@Column(name= "Name")
	private String name;
	
	@Column(name= "Password")
	private String password;
	
	
	@Column(name= "Role")
	private String role;
	
	
	@Column(name= "Active")
	private boolean active;

	/**
	 * Construtor vazio.
	 * 
	 **/
	public User() {}

	/**
	 * Construtor com o CPF.
	 * 
	 * @param cpf CPF de um usuario.
	 **/
	public User(String cpf) {
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public User(String cpf, String name) {
		this.cpf = cpf;
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Valida se o usuario esta ativo ou nao.
	 * 
	 * @return boolean
	 **/
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Valida se o usuario e valido atraves do CPF.
	 * 
	 * @return boolean
	 **/
	public boolean isValid() {
		return (this.cpf != null);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", cpf=" + cpf + ", email=" + email + ", matricula=" + matricula + ", name=" + name
				+ ", password=" + password + ", role=" + role + ", active=" + active + "]";
	}

}