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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "componenetes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c")
    , @NamedQuery(name = "Componente.findAllOrder", query = "SELECT c FROM Componente c ORDER BY c.descripcion")
    , @NamedQuery(name = "Componente.findByCodMarca", query = "SELECT c FROM Componente c WHERE c.codMarca = :codMarca")    
    , @NamedQuery(name = "Componente.findByCodComponente", query = "SELECT c FROM Componente c WHERE c.codComponente = :codComponente")
    , @NamedQuery(name = "Componente.findByDescripcion", query = "SELECT c FROM Componente c WHERE c.descripcion = :descripcion")})
public class Componente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codComponente")
    private Integer codComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codComponente")
    private Collection<Lineapproveedor> lineapproveedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componente")
    private Collection<Proveedorcomponente> proveedorcomponenteCollection;
    @JoinColumn(name = "codMarca", referencedColumnName = "codMarca")
    @ManyToOne(optional = false)
    private Marca codMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componente")
    private Collection<Productocomponente> productocomponenteCollection;

    public Componente() {
    }

    public Componente(Integer codComponente) {
        this.codComponente = codComponente;
    }

    public Componente(Integer codComponente, String descripcion) {
        this.codComponente = codComponente;
        this.descripcion = descripcion;
    }

    public Integer getCodComponente() {
        return codComponente;
    }

    public void setCodComponente(Integer codComponente) {
        this.codComponente = codComponente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Lineapproveedor> getLineapproveedorCollection() {
        return lineapproveedorCollection;
    }

    public void setLineapproveedorCollection(Collection<Lineapproveedor> lineapproveedorCollection) {
        this.lineapproveedorCollection = lineapproveedorCollection;
    }

    @XmlTransient
    public Collection<Proveedorcomponente> getProveedorcomponenteCollection() {
        return proveedorcomponenteCollection;
    }

    public void setProveedorcomponenteCollection(Collection<Proveedorcomponente> proveedorcomponenteCollection) {
        this.proveedorcomponenteCollection = proveedorcomponenteCollection;
    }

    public Marca getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Marca codMarca) {
        this.codMarca = codMarca;
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
        hash += (codComponente != null ? codComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.codComponente == null && other.codComponente != null) || (this.codComponente != null && !this.codComponente.equals(other.codComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Componente[ codComponente=" + codComponente + " ]";
    }
    
}
