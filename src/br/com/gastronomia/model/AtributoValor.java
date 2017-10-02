package br.com.gastronomia.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe modelo para o acesso ao banco de dados.
 *
 * @author Virgilius Santos - virgilius.santos@acad.pucrs.br
 * @since 11/08/2017
 *
 **/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "Atributo_Valor")
@JsonIgnoreProperties(ignoreUnknown=true)
public class AtributoValor implements Serializable {

    private static final long serialVersionUID = -78917652532826108L;

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_IdAtributo", nullable = false)
    private Atributo atributo;

    @Column(name = "Valor")
    private String valor;

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

    @Override
    public String toString() {
        return "IngredienteAtributo{" +
                "atributo=" + atributo +
                ", valor='" + valor + '\'' +
                '}';
    }
}
