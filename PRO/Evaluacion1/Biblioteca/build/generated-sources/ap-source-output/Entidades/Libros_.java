package Entidades;

import Entidades.Autores;
import Entidades.Premios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-05T12:46:51")
@StaticMetamodel(Libros.class)
public class Libros_ { 

    public static volatile ListAttribute<Libros, Premios> premiosList;
    public static volatile SingularAttribute<Libros, String> nomLibro;
    public static volatile SingularAttribute<Libros, Integer> ano;
    public static volatile SingularAttribute<Libros, String> pelicula;
    public static volatile SingularAttribute<Libros, Integer> codLibro;
    public static volatile ListAttribute<Libros, Autores> autoresList;
    public static volatile SingularAttribute<Libros, String> nomArchivo;
    public static volatile SingularAttribute<Libros, String> comentario;
    public static volatile SingularAttribute<Libros, String> portada;

}