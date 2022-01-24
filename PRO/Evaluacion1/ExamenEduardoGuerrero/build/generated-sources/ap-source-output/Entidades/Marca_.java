package Entidades;

import Entidades.Componente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Marca.class)
public class Marca_ { 

    public static volatile SingularAttribute<Marca, String> nomMarca;
    public static volatile SingularAttribute<Marca, Integer> codMarca;
    public static volatile CollectionAttribute<Marca, Componente> componenteCollection;

}