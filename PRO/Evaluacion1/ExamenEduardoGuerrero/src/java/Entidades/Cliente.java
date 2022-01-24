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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findAllOrder", query = "SELECT c FROM Cliente c ORDER BY c.nomCliente")
    , @NamedQuery(name = "Cliente.findByCodCliente", query = "SELECT c FROM Cliente c WHERE c.codCliente = :codCliente")
    , @NamedQuery(name = "Cliente.findByNomCliente", query = "SELECT c FROM Cliente c WHERE c.nomCliente = :nomCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codCliente")
    private Integer codCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomCliente")
    private String nomCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCliente")
    private Collection<Pedidocliente> pedidoclienteCollection;

    public Cliente() {
    }

    public Cliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Cliente(Integer codCliente, String nomCliente) {
        this.codCliente = codCliente;
        this.nomCliente = nomCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    @XmlTransient
    public Collection<Pedidocliente> getPedidoclienteCollection() {
        return pedidoclienteCollection;
    }

    public void setPedidoclienteCollection(Collection<Pedidocliente> pedidoclienteCollection) {
        this.pedidoclienteCollection = pedidoclienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cliente[ codCliente=" + codCliente + " ]";
    }
    
}
