/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edu7g
 */
@Entity
@Table(name = "productoscomponentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productocomponente.findAll", query = "SELECT p FROM Productocomponente p")
    , @NamedQuery(name = "Productocomponente.findByCodProducto", query = "SELECT p FROM Productocomponente p WHERE p.productocomponentePK.codProducto = :codProducto")
    , @NamedQuery(name = "Productocomponente.findByCodComponente", query = "SELECT p FROM Productocomponente p WHERE p.productocomponentePK.codComponente = :codComponente")
    , @NamedQuery(name = "Productocomponente.findByUnidades", query = "SELECT p FROM Productocomponente p WHERE p.unidades = :unidades")})
public class Productocomponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductocomponentePK productocomponentePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    @JoinColumn(name = "codProducto", referencedColumnName = "codProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productopropio productopropio;
    @JoinColumn(name = "codComponente", referencedColumnName = "codComponente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Componente componente;

    public Productocomponente() {
    }

    public Productocomponente(ProductocomponentePK productocomponentePK) {
        this.productocomponentePK = productocomponentePK;
    }

    public Productocomponente(ProductocomponentePK productocomponentePK, int unidades) {
        this.productocomponentePK = productocomponentePK;
        this.unidades = unidades;
    }

    public Productocomponente(int codProducto, int codComponente) {
        this.productocomponentePK = new ProductocomponentePK(codProducto, codComponente);
    }

    public ProductocomponentePK getProductocomponentePK() {
        return productocomponentePK;
    }

    public void setProductocomponentePK(ProductocomponentePK productocomponentePK) {
        this.productocomponentePK = productocomponentePK;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Productopropio getProductopropio() {
        return productopropio;
    }

    public void setProductopropio(Productopropio productopropio) {
        this.productopropio = productopropio;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productocomponentePK != null ? productocomponentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productocomponente)) {
            return false;
        }
        Productocomponente other = (Productocomponente) object;
        if ((this.productocomponentePK == null && other.productocomponentePK != null) || (this.productocomponentePK != null && !this.productocomponentePK.equals(other.productocomponentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Productocomponente[ productocomponentePK=" + productocomponentePK + " ]";
    }
    
}
