package entidades;

import entidades.JugadorEquipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(Jugador.class)
public class Jugador_ { 

    public static volatile SingularAttribute<Jugador, String> nombre;
    public static volatile SingularAttribute<Jugador, String> apellido;
    public static volatile SingularAttribute<Jugador, Integer> idJugador;
    public static volatile SingularAttribute<Jugador, Boolean> estado;
    public static volatile ListAttribute<Jugador, JugadorEquipo> jugadorEquipoList;
    public static volatile SingularAttribute<Jugador, Integer> semestre;

}