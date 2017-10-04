package br.com.gastronomia.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name= "Ingrediente_Atributo")
@AssociationOverrides({
        @AssociationOverride(name ="pk.item", joinColumns = @JoinColumn(name ="item_id")),
        @AssociationOverride(name ="pk.product", joinColumns = @JoinColumn(name ="product_id"))
})public class IngredienteAtributo implements Serializable {

    private static final long serialVersionUID = -78917652532826108L;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdIngrediente", nullable = false)
    @JsonBackReference
    private Ingrediente ingrediente;

    @Id
    @ManyToOne(
    @JoinColumn(name = "IdAtributo", nullable = false)
    private Atributo atributo;

    @Column(name = "Valor")
    private String valor;


    public IngredienteAtributo() {
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

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    @Override
    public String toString() {
        return "IngredienteAtributo{" +
                "ingrediente=" + ingrediente +
                ", atributo=" + atributo +
                ", valor='" + valor + '\'' +
                '}';
    }
}
