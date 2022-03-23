package Entidades;

import Entidades.AutorPremio;
import Entidades.Libros;
import Entidades.Paises;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-05T12:46:51")
@StaticMetamodel(Autores.class)
public class Autores_ { 

    public static volatile SingularAttribute<Autores, Date> fDef;
    public static volatile SingularAttribute<Autores, String> apellido2;
    public static volatile ListAttribute<Autores, AutorPremio> autorPremioList;
    public static volatile SingularAttribute<Autores, String> foto;
    public static volatile SingularAttribute<Autores, Date> fNac;
    public static volatile SingularAttribute<Autores, String> apellido1;
    public static volatile ListAttribute<Autores, Libros> librosList;
    public static volatile SingularAttribute<Autores, String> nomAutor;
    public static volatile SingularAttribute<Autores, String> biografia;
    public static volatile SingularAttribute<Autores, String> localidad;
    public static volatile SingularAttribute<Autores, Integer> codAutor;
    public static volatile SingularAttribute<Autores, Paises> nacionalidad;

}