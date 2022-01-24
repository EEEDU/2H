package Entidades;

import Entidades.Componente;
import Entidades.ProductocomponentePK;
import Entidades.Productopropio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Productocomponente.class)
public class Productocomponente_ { 

    public static volatile SingularAttribute<Productocomponente, Productopropio> productopropio;
    public static volatile SingularAttribute<Productocomponente, Integer> unidades;
    public static volatile SingularAttribute<Productocomponente, Componente> componente;
    public static volatile SingularAttribute<Productocomponente, ProductocomponentePK> productocomponentePK;

}