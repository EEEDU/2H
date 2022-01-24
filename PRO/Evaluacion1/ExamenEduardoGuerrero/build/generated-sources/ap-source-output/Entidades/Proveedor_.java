package Entidades;

import Entidades.Pedidoproveedor;
import Entidades.Proveedorcomponente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, Integer> codProveedor;
    public static volatile SingularAttribute<Proveedor, String> nomProveedor;
    public static volatile CollectionAttribute<Proveedor, Pedidoproveedor> pedidoproveedorCollection;
    public static volatile CollectionAttribute<Proveedor, Proveedorcomponente> proveedorcomponenteCollection;

}