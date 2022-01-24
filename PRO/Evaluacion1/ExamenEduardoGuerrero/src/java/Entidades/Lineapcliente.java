/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "lineaspclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineapcliente.findAll", query = "SELECT l FROM Lineapcliente l")
    , @NamedQuery(name = "Lineapcliente.findByIdLinea", query = "SELECT l FROM Lineapcliente l WHERE l.idLinea = :idLinea")
    , @NamedQuery(name = "Lineapcliente.findByProducto", query = "SELECT l FROM Lineapcliente l WHERE l.codProducto = :codProducto")
    , @NamedQuery(name = "Lineapcliente.findByCantidad", query = "SELECT l FROM Lineapcliente l WHERE l.cantidad = :cantidad")})
public class Lineapcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLinea")
    private Integer idLinea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "codPedidoCliente", referencedColumnName = "codPedidoCliente")
    @ManyToOne(optional = false)
    private Pedidocliente codPedidoCliente;
    @JoinColumn(name = "codProducto", referencedColumnName = "codProducto")
    @ManyToOne(optional = false)
    private Productopropio codProducto;

    public Lineapcliente() {
    }

    public Lineapcliente(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public Lineapcliente(Integer idLinea, int cantidad) {
        this.idLinea = idLinea;
        this.cantidad = cantidad;
    }

    public Integer getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedidocliente getCodPedidoCliente() {
        return codPedidoCliente;
    }

    public void setCodPedidoCliente(Pedidocliente codPedidoCliente) {
        this.codPedidoCliente = codPedidoCliente;
    }

    public Productopropio getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Productopropio codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinea != null ? idLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineapcliente)) {
            return false;
        }
        Lineapcliente other = (Lineapcliente) object;
        if ((this.idLinea == null && other.idLinea != null) || (this.idLinea != null && !this.idLinea.equals(other.idLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Lineapcliente[ idLinea=" + idLinea + " ]";
    }
    
}
