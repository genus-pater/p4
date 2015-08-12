package entidades;

import entidades.Escuela;
import entidades.Inscripcion;
import entidades.JugadorEquipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(Equipo.class)
public class Equipo_ { 

    public static volatile SingularAttribute<Equipo, String> nombre;
    public static volatile ListAttribute<Equipo, JugadorEquipo> jugadorEquipoList;
    public static volatile ListAttribute<Equipo, Inscripcion> inscripcionList;
    public static volatile SingularAttribute<Equipo, Escuela> idEscuela;
    public static volatile SingularAttribute<Equipo, Integer> idEquipo;

}