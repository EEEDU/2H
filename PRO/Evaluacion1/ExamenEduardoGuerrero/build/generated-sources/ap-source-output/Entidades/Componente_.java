package Entidades;

import Entidades.Lineapproveedor;
import Entidades.Marca;
import Entidades.Productocomponente;
import Entidades.Proveedorcomponente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-30T13:29:42")
@StaticMetamodel(Componente.class)
public class Componente_ { 

    public static volatile SingularAttribute<Componente, String> descripcion;
    public static volatile SingularAttribute<Componente, Marca> codMarca;
    public static volatile CollectionAttribute<Componente, Productocomponente> productocomponenteCollection;
    public static volatile CollectionAttribute<Componente, Lineapproveedor> lineapproveedorCollection;
    public static volatile SingularAttribute<Componente, Integer> codComponente;
    public static volatile CollectionAttribute<Componente, Proveedorcomponente> proveedorcomponenteCollection;

}