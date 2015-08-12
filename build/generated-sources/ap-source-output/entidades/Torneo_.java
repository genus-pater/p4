package entidades;

import entidades.DisciplinaTorneo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-12T08:13:10")
@StaticMetamodel(Torneo.class)
public class Torneo_ { 

    public static volatile SingularAttribute<Torneo, String> descripcion;
    public static volatile SingularAttribute<Torneo, Boolean> estado;
    public static volatile SingularAttribute<Torneo, Date> fechaInicio;
    public static volatile ListAttribute<Torneo, DisciplinaTorneo> disciplinaTorneoList;
    public static volatile SingularAttribute<Torneo, Date> fechaFin;
    public static volatile SingularAttribute<Torneo, Integer> idTorneo;

}