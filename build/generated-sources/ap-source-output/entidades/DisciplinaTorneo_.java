package entidades;

import entidades.Disciplina;
import entidades.DisciplinaTorneoPK;
import entidades.Encuentro;
import entidades.Inscripcion;
import entidades.Torneo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-13T16:15:20")
@StaticMetamodel(DisciplinaTorneo.class)
public class DisciplinaTorneo_ { 

    public static volatile SingularAttribute<DisciplinaTorneo, Date> fecha;
    public static volatile SingularAttribute<DisciplinaTorneo, Torneo> torneo;
    public static volatile SingularAttribute<DisciplinaTorneo, DisciplinaTorneoPK> disciplinaTorneoPK;
    public static volatile SingularAttribute<DisciplinaTorneo, Disciplina> disciplina;
    public static volatile ListAttribute<DisciplinaTorneo, Inscripcion> inscripcionList;
    public static volatile ListAttribute<DisciplinaTorneo, Encuentro> encuentroList;

}