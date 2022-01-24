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
public class ProductocomponentePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codProducto")
    private int codProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codComponente")
    private int codComponente;

    public ProductocomponentePK() {
    }

    public ProductocomponentePK(int codProducto, int codComponente) {
        this.codProducto = codProducto;
        this.codComponente = codComponente;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
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
        hash += (int) codProducto;
        hash += (int) codComponente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductocomponentePK)) {
            return false;
        }
        ProductocomponentePK other = (ProductocomponentePK) object;
        if (this.codProducto != other.codProducto) {
            return false;
        }
        if (this.codComponente != other.codComponente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProductocomponentePK[ codProducto=" + codProducto + ", codComponente=" + codComponente + " ]";
    }
    
}
