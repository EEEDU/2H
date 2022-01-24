package Entidades;

import Entidades.Pedidocliente;
import Entidades.Productopropio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Lineapcliente.class)
public class Lineapcliente_ { 

    public static volatile SingularAttribute<Lineapcliente, Integer> idLinea;
    public static volatile SingularAttribute<Lineapcliente, Productopropio> codProducto;
    public static volatile SingularAttribute<Lineapcliente, Pedidocliente> codPedidoCliente;
    public static volatile SingularAttribute<Lineapcliente, Integer> cantidad;

}