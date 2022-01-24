/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edu7g
 */
@Entity
@Table(name = "pedidosproveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidoproveedor.findAll", query = "SELECT p FROM Pedidoproveedor p")
    , @NamedQuery(name = "Pedidoproveedor.findByNumPedido", query = "SELECT p FROM Pedidoproveedor p WHERE p.numPedido = :numPedido")
    , @NamedQuery(name = "Pedidoproveedor.findByFecha", query = "SELECT p FROM Pedidoproveedor p WHERE p.fecha = :fecha")})
public class Pedidoproveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numPedido")
    private Integer numPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "codProveedor", referencedColumnName = "codProveedor")
    @ManyToOne(optional = false)
    private Proveedor codProveedor;

    public Pedidoproveedor() {
    }

    public Pedidoproveedor(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Pedidoproveedor(Integer numPedido, Date fecha) {
        this.numPedido = numPedido;
        this.fecha = fecha;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPedido != null ? numPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidoproveedor)) {
            return false;
        }
        Pedidoproveedor other = (Pedidoproveedor) object;
        if ((this.numPedido == null && other.numPedido != null) || (this.numPedido != null && !this.numPedido.equals(other.numPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedidoproveedor[ numPedido=" + numPedido + " ]";
    }
    
}
