package entidades;

import entidades.Escuela;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-12T08:13:10")
@StaticMetamodel(Facultad.class)
public class Facultad_ { 

    public static volatile SingularAttribute<Facultad, Boolean> estado;
    public static volatile ListAttribute<Facultad, Escuela> escuelaList;
    public static volatile SingularAttribute<Facultad, String> nombre;
    public static volatile SingularAttribute<Facultad, Integer> idFacultad;

}