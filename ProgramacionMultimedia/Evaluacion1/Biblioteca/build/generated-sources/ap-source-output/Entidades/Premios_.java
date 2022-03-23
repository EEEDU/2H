package Entidades;

import Entidades.AutorPremio;
import Entidades.Libros;
import Entidades.Paises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-05T12:46:51")
@StaticMetamodel(Premios.class)
public class Premios_ { 

    public static volatile SingularAttribute<Premios, Character> tipo;
    public static volatile ListAttribute<Premios, AutorPremio> autorPremioList;
    public static volatile ListAttribute<Premios, Libros> librosList;
    public static volatile SingularAttribute<Premios, String> nomPremio;
    public static volatile SingularAttribute<Premios, Integer> codPremio;
    public static volatile SingularAttribute<Premios, Paises> codPais;

}