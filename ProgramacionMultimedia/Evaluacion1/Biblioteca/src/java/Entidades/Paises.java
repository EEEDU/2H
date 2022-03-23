/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p")
    , @NamedQuery(name = "Paises.findAllOrder", query = "SELECT p FROM Paises p ORDER BY p.nomPais")
    , @NamedQuery(name = "Paises.findByCodPais", query = "SELECT p FROM Paises p WHERE p.codPais = :codPais")
    , @NamedQuery(name = "Paises.findByBandera", query = "SELECT p FROM Paises p WHERE p.bandera = :bandera")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_pais")
    private Integer codPais;
    @Lob
    @Size(max = 65535)
    @Column(name = "nom_pais")
    private String nomPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "bandera")
    private String bandera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPais")
    private List<Premios> premiosList;
    @OneToMany(mappedBy = "nacionalidad")
    private List<Autores> autoresList;

    public Paises() {
    }

    public Paises(Integer codPais) {
        this.codPais = codPais;
    }

    public Paises(Integer codPais, String bandera) {
        this.codPais = codPais;
        this.bandera = bandera;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    @XmlTransient
    public List<Premios> getPremiosList() {
        return premiosList;
    }

    public void setPremiosList(List<Premios> premiosList) {
        this.premiosList = premiosList;
    }

    @XmlTransient
    public List<Autores> getAutoresList() {
        return autoresList;
    }

    public void setAutoresList(List<Autores> autoresList) {
        this.autoresList = autoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Paises[ codPais=" + codPais + " ]";
    }
    
}
