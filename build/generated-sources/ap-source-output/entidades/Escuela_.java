package entidades;

import entidades.Equipo;
import entidades.Facultad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-13T16:15:20")
@StaticMetamodel(Escuela.class)
public class Escuela_ { 

    public static volatile SingularAttribute<Escuela, Boolean> estado;
    public static volatile SingularAttribute<Escuela, Integer> idEscuela;
    public static volatile ListAttribute<Escuela, Equipo> equipoList;
    public static volatile SingularAttribute<Escuela, String> nombre;
    public static volatile SingularAttribute<Escuela, Facultad> idFacultad;

}