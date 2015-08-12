package entidades;

import entidades.Clasificatoria;
import entidades.DisciplinaTorneo;
import entidades.Equipo;
import entidades.EquiposAJugar;
import entidades.InscripcionPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(Inscripcion.class)
public class Inscripcion_ { 

    public static volatile SingularAttribute<Inscripcion, Equipo> equipo;
    public static volatile SingularAttribute<Inscripcion, DisciplinaTorneo> disciplinaTorneo;
    public static volatile SingularAttribute<Inscripcion, Date> fecha;
    public static volatile ListAttribute<Inscripcion, EquiposAJugar> equiposAJugarList;
    public static volatile SingularAttribute<Inscripcion, InscripcionPK> inscripcionPK;
    public static volatile ListAttribute<Inscripcion, Clasificatoria> clasificatoriaList;

}