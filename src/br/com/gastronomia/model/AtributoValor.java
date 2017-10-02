package br.com.gastronomia.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe modelo para o acesso ao banco de dados.
 *
 * @author Virgilius Santos - virgilius.santos@acad.pucrs.br
 * @since
 *
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "Ingrediente_Atributo")
public class AtributoValor implements Serializable {

    private static final long serialVersionUID = -78917652532826108L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdIngredienteAtributo")
    private long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_IdAtributo", nullable = false)
    private Atributo atributo;

    @Column(name = "Valor")
    private String valor;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_IdIngrediente", nullable = false)
    @JsonBackReference
    private Ingrediente ingrediente;

    public AtributoValor() {
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "IngredienteAtributo{" +
                "atributo=" + atributo +
                ", valor='" + valor + '\'' +
                '}';
    }
}
