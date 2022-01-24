/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edu7g
 */
@Entity
@Table(name = "marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m")
    , @NamedQuery(name = "Marca.findByCodMarca", query = "SELECT m FROM Marca m WHERE m.codMarca = :codMarca")
    , @NamedQuery(name = "Marca.findByNomMarca", query = "SELECT m FROM Marca m WHERE m.nomMarca = :nomMarca")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codMarca")
    private Integer codMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomMarca")
    private String nomMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMarca")
    private Collection<Componenete> componeneteCollection;

    public Marca() {
    }

    public Marca(Integer codMarca) {
        this.codMarca = codMarca;
    }

    public Marca(Integer codMarca, String nomMarca) {
        this.codMarca = codMarca;
        this.nomMarca = nomMarca;
    }

    public Integer getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Integer codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomMarca() {
        return nomMarca;
    }

    public void setNomMarca(String nomMarca) {
        this.nomMarca = nomMarca;
    }

    @XmlTransient
    public Collection<Componenete> getComponeneteCollection() {
        return componeneteCollection;
    }

    public void setComponeneteCollection(Collection<Componenete> componeneteCollection) {
        this.componeneteCollection = componeneteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMarca != null ? codMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.codMarca == null && other.codMarca != null) || (this.codMarca != null && !this.codMarca.equals(other.codMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Marca[ codMarca=" + codMarca + " ]";
    }
    
}
