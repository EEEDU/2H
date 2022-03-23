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
@Table(name = "productospropios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productopropio.findAll", query = "SELECT p FROM Productopropio p")
    , @NamedQuery(name = "Productopropio.findByCodProducto", query = "SELECT p FROM Productopropio p WHERE p.codProducto = :codProducto")
    , @NamedQuery(name = "Productopropio.findByDenominacion", query = "SELECT p FROM Productopropio p WHERE p.denominacion = :denominacion")
    , @NamedQuery(name = "Productopropio.findByPrecio", query = "SELECT p FROM Productopropio p WHERE p.precio = :precio")})
public class Productopropio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codProducto")
    private Integer codProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "denominacion")
    private String denominacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProducto")
    private Collection<Lineapcliente> lineapclienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productopropio")
    private Collection<Productocomponente> productocomponenteCollection;

    public Productopropio() {
    }

    public Productopropio(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public Productopropio(Integer codProducto, String denominacion, double precio) {
        this.codProducto = codProducto;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Lineapcliente> getLineapclienteCollection() {
        return lineapclienteCollection;
    }

    public void setLineapclienteCollection(Collection<Lineapcliente> lineapclienteCollection) {
        this.lineapclienteCollection = lineapclienteCollection;
    }

    @XmlTransient
    public Collection<Productocomponente> getProductocomponenteCollection() {
        return productocomponenteCollection;
    }

    public void setProductocomponenteCollection(Collection<Productocomponente> productocomponenteCollection) {
        this.productocomponenteCollection = productocomponenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productopropio)) {
            return false;
        }
        Productopropio other = (Productopropio) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Productopropio[ codProducto=" + codProducto + " ]";
    }
    
}
