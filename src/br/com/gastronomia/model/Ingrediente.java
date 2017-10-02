package br.com.gastronomia.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = -789863172532826108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdIngrediente")
	private long id;

	@Column(name = "Nome")
	private String nome;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_IdUsuario", nullable = false)
	private Usuario criador;

	@Column(name = "Origem")
	private String origem;

    //Relacionamento implementado -- lado forte
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
	private List<IngredienteAtributo> ingredienteAtributo;

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

	public Usuario getCriador() { return criador; }

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public List<IngredienteAtributo> getIngredienteAtributo() {
		return ingredienteAtributo;
	}

	public void setIngredienteAtributo(List<IngredienteAtributo> ingredienteAtributo) {
		this.ingredienteAtributo = ingredienteAtributo;
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
                ", criador=" + criador +
                ", origem='" + origem + '\'' +
                ", ingredienteAtributo=" + ingredienteAtributo +
                ", status=" + status +
                '}';
    }
}