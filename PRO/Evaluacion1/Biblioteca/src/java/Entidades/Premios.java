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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "premios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Premios.findAll", query = "SELECT p FROM Premios p ORDER BY p.nomPremio")
    , @NamedQuery(name = "Premios.findByCodPremio", query = "SELECT p FROM Premios p WHERE p.codPremio = :codPremio")
    , @NamedQuery(name = "Premios.findByAutor", query = "SELECT p FROM Premios p WHERE p.autorPremioList = :autor")
    , @NamedQuery(name = "Premios.findByPais", query = "SELECT p FROM Premios p WHERE p.codPais = :elPais")
    , @NamedQuery(name = "Premios.findByTipo", query = "SELECT p FROM Premios p WHERE p.tipo = :tipo")})
public class Premios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_premio")
    private Integer codPremio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_premio")
    private String nomPremio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @ManyToMany(mappedBy = "premiosList")
    private List<Libros> librosList;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Paises codPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "premios")
    private List<AutorPremio> autorPremioList;

    public Premios() {
    }

    public Premios(Integer codPremio) {
        this.codPremio = codPremio;
    }

    public Premios(Integer codPremio, String nomPremio, Character tipo) {
        this.codPremio = codPremio;
        this.nomPremio = nomPremio;
        this.tipo = tipo;
    }

    public Integer getCodPremio() {
        return codPremio;
    }

    public void setCodPremio(Integer codPremio) {
        this.codPremio = codPremio;
    }

    public String getNomPremio() {
        return nomPremio;
    }

    public void setNomPremio(String nomPremio) {
        this.nomPremio = nomPremio;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Libros> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libros> librosList) {
        this.librosList = librosList;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    @XmlTransient
    public List<AutorPremio> getAutorPremioList() {
        return autorPremioList;
    }

    public void setAutorPremioList(List<AutorPremio> autorPremioList) {
        this.autorPremioList = autorPremioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPremio != null ? codPremio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Premios)) {
            return false;
        }
        Premios other = (Premios) object;
        if ((this.codPremio == null && other.codPremio != null) || (this.codPremio != null && !this.codPremio.equals(other.codPremio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Premios[ codPremio=" + codPremio + " ]";
    }
    
}
