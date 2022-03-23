package Entidades;

import Entidades.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Pedidoproveedor.class)
public class Pedidoproveedor_ { 

    public static volatile SingularAttribute<Pedidoproveedor, Integer> numPedido;
    public static volatile SingularAttribute<Pedidoproveedor, Date> fecha;
    public static volatile SingularAttribute<Pedidoproveedor, Proveedor> codProveedor;

}