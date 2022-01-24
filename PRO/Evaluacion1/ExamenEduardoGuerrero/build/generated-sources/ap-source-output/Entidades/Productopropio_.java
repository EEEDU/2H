package Entidades;

import Entidades.Lineapcliente;
import Entidades.Productocomponente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Productopropio.class)
public class Productopropio_ { 

    public static volatile SingularAttribute<Productopropio, Integer> codProducto;
    public static volatile SingularAttribute<Productopropio, Double> precio;
    public static volatile SingularAttribute<Productopropio, String> denominacion;
    public static volatile CollectionAttribute<Productopropio, Lineapcliente> lineapclienteCollection;
    public static volatile CollectionAttribute<Productopropio, Productocomponente> productocomponenteCollection;

}