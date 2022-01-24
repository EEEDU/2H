package Entidades;

import Entidades.Autores;
import Entidades.Premios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-05T12:46:51")
@StaticMetamodel(Paises.class)
public class Paises_ { 

    public static volatile ListAttribute<Paises, Premios> premiosList;
    public static volatile SingularAttribute<Paises, Integer> codPais;
    public static volatile SingularAttribute<Paises, String> nomPais;
    public static volatile SingularAttribute<Paises, String> bandera;
    public static volatile ListAttribute<Paises, Autores> autoresList;

}