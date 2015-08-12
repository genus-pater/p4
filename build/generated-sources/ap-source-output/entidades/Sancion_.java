package entidades;

import entidades.JugadorEquipoSancion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-12T08:13:10")
@StaticMetamodel(Sancion.class)
public class Sancion_ { 

    public static volatile SingularAttribute<Sancion, String> descripcion;
    public static volatile SingularAttribute<Sancion, Integer> idSancion;
    public static volatile ListAttribute<Sancion, JugadorEquipoSancion> jugadorEquipoSancionList;
    public static volatile SingularAttribute<Sancion, String> nombre;

}