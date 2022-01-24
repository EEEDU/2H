package Entidades;

import Entidades.Pedidocliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> nomCliente;
    public static volatile SingularAttribute<Cliente, Integer> codCliente;
    public static volatile CollectionAttribute<Cliente, Pedidocliente> pedidoclienteCollection;

}