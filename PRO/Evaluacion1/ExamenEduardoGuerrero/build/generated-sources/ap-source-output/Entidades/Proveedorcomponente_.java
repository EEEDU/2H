package Entidades;

import Entidades.Componente;
import Entidades.Proveedor;
import Entidades.ProveedorcomponentePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Proveedorcomponente.class)
public class Proveedorcomponente_ { 

    public static volatile SingularAttribute<Proveedorcomponente, Double> precio;
    public static volatile SingularAttribute<Proveedorcomponente, ProveedorcomponentePK> proveedorcomponentePK;
    public static volatile SingularAttribute<Proveedorcomponente, Proveedor> proveedor;
    public static volatile SingularAttribute<Proveedorcomponente, Componente> componente;
    public static volatile SingularAttribute<Proveedorcomponente, Integer> numUnidades;

}