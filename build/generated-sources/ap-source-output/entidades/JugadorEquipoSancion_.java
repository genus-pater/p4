package entidades;

import entidades.JugadorEquipo;
import entidades.JugadorEquipoSancionPK;
import entidades.Sancion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-12T08:13:10")
@StaticMetamodel(JugadorEquipoSancion.class)
public class JugadorEquipoSancion_ { 

    public static volatile SingularAttribute<JugadorEquipoSancion, Date> fechaInicio;
    public static volatile SingularAttribute<JugadorEquipoSancion, JugadorEquipoSancionPK> jugadorEquipoSancionPK;
    public static volatile SingularAttribute<JugadorEquipoSancion, Sancion> sancion;
    public static volatile SingularAttribute<JugadorEquipoSancion, JugadorEquipo> jugadorEquipo;
    public static volatile SingularAttribute<JugadorEquipoSancion, Date> fechaFin;

}