package Entidades;

import Entidades.Cliente;
import Entidades.Lineapcliente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Pedidocliente.class)
public class Pedidocliente_ { 

    public static volatile SingularAttribute<Pedidocliente, Date> fecha;
    public static volatile SingularAttribute<Pedidocliente, Integer> codPedidoCliente;
    public static volatile CollectionAttribute<Pedidocliente, Lineapcliente> lineapclienteCollection;
    public static volatile SingularAttribute<Pedidocliente, Cliente> codCliente;

}