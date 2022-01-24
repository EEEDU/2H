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
@Table(name = "lineaspproveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineapproveedor.findAll", query = "SELECT l FROM Lineapproveedor l")
    , @NamedQuery(name = "Lineapproveedor.findByCodLineaPP", query = "SELECT l FROM Lineapproveedor l WHERE l.codLineaPP = :codLineaPP")
    , @NamedQuery(name = "Lineapproveedor.findByNumUnidades", query = "SELECT l FROM Lineapproveedor l WHERE l.numUnidades = :numUnidades")
    , @NamedQuery(name = "Lineapproveedor.findByCodPedidoProveedor", query = "SELECT l FROM Lineapproveedor l WHERE l.codPedidoProveedor = :codPedidoProveedor")})
public class Lineapproveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codLineaPP")
    private Integer codLineaPP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numUnidades")
    private int numUnidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPedidoProveedor")
    private int codPedidoProveedor;
    @JoinColumn(name = "codComponente", referencedColumnName = "codComponente")
    @ManyToOne(optional = false)
    private Componente codComponente;

    public Lineapproveedor() {
    }

    public Lineapproveedor(Integer codLineaPP) {
        this.codLineaPP = codLineaPP;
    }

    public Lineapproveedor(Integer codLineaPP, int numUnidades, int codPedidoProveedor) {
        this.codLineaPP = codLineaPP;
        this.numUnidades = numUnidades;
        this.codPedidoProveedor = codPedidoProveedor;
    }

    public Integer getCodLineaPP() {
        return codLineaPP;
    }

    public void setCodLineaPP(Integer codLineaPP) {
        this.codLineaPP = codLineaPP;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    public int getCodPedidoProveedor() {
        return codPedidoProveedor;
    }

    public void setCodPedidoProveedor(int codPedidoProveedor) {
        this.codPedidoProveedor = codPedidoProveedor;
    }

    public Componente getCodComponente() {
        return codComponente;
    }

    public void setCodComponente(Componente codComponente) {
        this.codComponente = codComponente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLineaPP != null ? codLineaPP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineapproveedor)) {
            return false;
        }
        Lineapproveedor other = (Lineapproveedor) object;
        if ((this.codLineaPP == null && other.codLineaPP != null) || (this.codLineaPP != null && !this.codLineaPP.equals(other.codLineaPP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Lineapproveedor[ codLineaPP=" + codLineaPP + " ]";
    }
    
}
