/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edu7g
 */
@Entity
@Table(name = "autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a")
    , @NamedQuery(name = "Autores.findByCodAutor", query = "SELECT a FROM Autores a WHERE a.codAutor = :codAutor")
    , @NamedQuery(name = "Autores.findAllOrder", query = "SELECT a FROM Autores a ORDER BY a.apellido1")
    , @NamedQuery(name = "Autores.findByNomAutor", query = "SELECT a FROM Autores a WHERE a.nomAutor = :nomAutor")
    , @NamedQuery(name = "Autores.findByApellido1", query = "SELECT a FROM Autores a WHERE a.apellido1 = :apellido1")
    , @NamedQuery(name = "Autores.findByApellido2", query = "SELECT a FROM Autores a WHERE a.apellido2 = :apellido2")
    , @NamedQuery(name = "Autores.findByFNac", query = "SELECT a FROM Autores a WHERE a.fNac = :fNac")
    , @NamedQuery(name = "Autores.findByFDef", query = "SELECT a FROM Autores a WHERE a.fDef = :fDef")
    , @NamedQuery(name = "Autores.findByFoto", query = "SELECT a FROM Autores a WHERE a.foto = :foto")
    , @NamedQuery(name = "Autores.findByPais", query = "SELECT a FROM Autores a WHERE a.nacionalidad = :elPais")
    , @NamedQuery(name = "Autores.findByPremio", query = "SELECT a FROM Autores a WHERE a.codAutor =  :elPremio")
     , @NamedQuery(name = "Autores.findByLocalidad", query = "SELECT a FROM Autores a WHERE a.localidad = :localidad")})
public class Autores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_autor")
    private Integer codAutor;
    @Size(max = 20)
    @Column(name = "nom_autor")
    private String nomAutor;
    @Size(max = 25)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 25)
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "f_nac")
    @Temporal(TemporalType.DATE)
    private Date fNac;
    @Column(name = "f_def")
    @Temporal(TemporalType.DATE)
    private Date fDef;
    @Size(max = 30)
    @Column(name = "foto")
    private String foto;
    @Size(max = 50)
    @Column(name = "localidad")
    private String localidad;
    @Lob
    @Size(max = 16777215)
    @Column(name = "biografia")
    private String biografia;
    @ManyToMany(mappedBy = "autoresList")
    private List<Libros> librosList;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "cod_pais")
    @ManyToOne
    private Paises nacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autores")
    private List<AutorPremio> autorPremioList;

    public Autores() {
    }

    public Autores(Integer codAutor) {
        this.codAutor = codAutor;
    }

    public Integer getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(Integer codAutor) {
        this.codAutor = codAutor;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFNac() {
        return fNac;
    }

    public void setFNac(Date fNac) {
        this.fNac = fNac;
    }

    public Date getFDef() {
        return fDef;
    }

    public void setFDef(Date fDef) {
        this.fDef = fDef;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @XmlTransient
    public List<Libros> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libros> librosList) {
        this.librosList = librosList;
    }

    public Paises getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Paises nacionalidad) {
        this.nacionalidad = nacionalidad;
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
        hash += (codAutor != null ? codAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.codAutor == null && other.codAutor != null) || (this.codAutor != null && !this.codAutor.equals(other.codAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Autores[ codAutor=" + codAutor + " ]";
    }
    
}
