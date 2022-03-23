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
@Table(name = "proveedorescomponentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedorcomponente.findAll", query = "SELECT p FROM Proveedorcomponente p")
    , @NamedQuery(name = "Proveedorcomponente.findByCodProveedor", query = "SELECT p FROM Proveedorcomponente p WHERE p.proveedorcomponentePK.codProveedor = :codProveedor")
    , @NamedQuery(name = "Proveedorcomponente.findByCodComponente", query = "SELECT p FROM Proveedorcomponente p WHERE p.proveedorcomponentePK.codComponente = :codComponente")
    , @NamedQuery(name = "Proveedorcomponente.findByNumUnidades", query = "SELECT p FROM Proveedorcomponente p WHERE p.numUnidades = :numUnidades")
    , @NamedQuery(name = "Proveedorcomponente.findByPrecio", query = "SELECT p FROM Proveedorcomponente p WHERE p.precio = :precio")})
public class Proveedorcomponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProveedorcomponentePK proveedorcomponentePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numUnidades")
    private int numUnidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "codComponente", referencedColumnName = "codComponente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Componenete componenete;
    @JoinColumn(name = "codProveedor", referencedColumnName = "codProveedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedor proveedor;

    public Proveedorcomponente() {
    }

    public Proveedorcomponente(ProveedorcomponentePK proveedorcomponentePK) {
        this.proveedorcomponentePK = proveedorcomponentePK;
    }

    public Proveedorcomponente(ProveedorcomponentePK proveedorcomponentePK, int numUnidades, double precio) {
        this.proveedorcomponentePK = proveedorcomponentePK;
        this.numUnidades = numUnidades;
        this.precio = precio;
    }

    public Proveedorcomponente(int codProveedor, int codComponente) {
        this.proveedorcomponentePK = new ProveedorcomponentePK(codProveedor, codComponente);
    }

    public ProveedorcomponentePK getProveedorcomponentePK() {
        return proveedorcomponentePK;
    }

    public void setProveedorcomponentePK(ProveedorcomponentePK proveedorcomponentePK) {
        this.proveedorcomponentePK = proveedorcomponentePK;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Componenete getComponenete() {
        return componenete;
    }

    public void setComponenete(Componenete componenete) {
        this.componenete = componenete;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorcomponentePK != null ? proveedorcomponentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedorcomponente)) {
            return false;
        }
        Proveedorcomponente other = (Proveedorcomponente) object;
        if ((this.proveedorcomponentePK == null && other.proveedorcomponentePK != null) || (this.proveedorcomponentePK != null && !this.proveedorcomponentePK.equals(other.proveedorcomponentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Proveedorcomponente[ proveedorcomponentePK=" + proveedorcomponentePK + " ]";
    }
    
}
