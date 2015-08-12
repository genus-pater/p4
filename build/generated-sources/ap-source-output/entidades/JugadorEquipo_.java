package entidades;

import entidades.Anotacion;
import entidades.Equipo;
import entidades.Jugador;
import entidades.JugadorEquipoPK;
import entidades.JugadorEquipoSancion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-12T08:13:10")
@StaticMetamodel(JugadorEquipo.class)
public class JugadorEquipo_ { 

    public static volatile SingularAttribute<JugadorEquipo, Byte[]> foto;
    public static volatile ListAttribute<JugadorEquipo, JugadorEquipoSancion> jugadorEquipoSancionList;
    public static volatile SingularAttribute<JugadorEquipo, JugadorEquipoPK> jugadorEquipoPK;
    public static volatile SingularAttribute<JugadorEquipo, Jugador> jugador;
    public static volatile SingularAttribute<JugadorEquipo, Equipo> equipo;
    public static volatile SingularAttribute<JugadorEquipo, Integer> nJugador;
    public static volatile ListAttribute<JugadorEquipo, Anotacion> anotacionList;

}