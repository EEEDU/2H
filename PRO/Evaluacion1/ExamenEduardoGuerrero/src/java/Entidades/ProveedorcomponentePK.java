/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author edu7g
 */
@Embeddable
public class ProveedorcomponentePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codProveedor")
    private int codProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codComponente")
    private int codComponente;

    public ProveedorcomponentePK() {
    }

    public ProveedorcomponentePK(int codProveedor, int codComponente) {
        this.codProveedor = codProveedor;
        this.codComponente = codComponente;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public int getCodComponente() {
        return codComponente;
    }

    public void setCodComponente(int codComponente) {
        this.codComponente = codComponente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codProveedor;
        hash += (int) codComponente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorcomponentePK)) {
            return false;
        }
        ProveedorcomponentePK other = (ProveedorcomponentePK) object;
        if (this.codProveedor != other.codProveedor) {
            return false;
        }
        if (this.codComponente != other.codComponente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProveedorcomponentePK[ codProveedor=" + codProveedor + ", codComponente=" + codComponente + " ]";
    }
    
}
