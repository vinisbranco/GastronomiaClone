package br.com.gastronomia.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import br.com.gastronomia.util.TipoDeUsuario;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Classe modelo para o acesso ao banco de dados.
 * Feito a partir da classe Usuario do projeto IdeiasAges
 * 
 * @author Pedro Bledow - pedro.bledow@acad.pucrs.br
 * @since 06/09/2017
 * 
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "Usuario")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuario implements Serializable {

	private static final long serialVersionUID = -789863172532826108L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdUsuario")
	private long id;

	@NotEmpty
	@Column(name = "Cpf", unique = true)
	private String cpf;

	@NotEmpty
	@Email(message="E-mail invalido")
	@Column(name = "Email", unique = true)
	private String email;

	@NotEmpty
	@Column(name = "Matricula", unique = true)
	private String matricula;

	@NotEmpty
	@Column(name= "Nome")
	private String nome;

	@NotEmpty
	@Column(name= "Senha")
	private String senha;

    @Column(name= "Tipo")
    @Enumerated(EnumType.STRING)
	private TipoDeUsuario tipo;
	
	
	@Column(name= "Status", nullable = false)
	private boolean status;

	/**
	 * Construtor vazio.
	 * 
	 **/
	public Usuario() {}

	/**
	 * Construtor com o CPF.
	 * 
	 * @param cpf CPF de um usuario.
	 **/
	public Usuario(String cpf) {
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public Usuario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
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
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoDeUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeUsuario tipo) {
		this.tipo = tipo;
	}

	/**
	 * Valida se o usuario esta ativo ou nao.
	 * 
	 * @return boolean
	 **/
	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
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
		return "Usuario [id=" + id + ", cpf=" + cpf + ", email=" + email + ", matricula=" + matricula + ", nome=" + nome
				+ ", senha=" + senha + ", tipo=" + tipo.toString() + ", status=" + status + "]";
	}

}