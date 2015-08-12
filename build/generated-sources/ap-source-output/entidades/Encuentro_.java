package entidades;

import entidades.Arbitro;
import entidades.Cancha;
import entidades.DisciplinaTorneo;
import entidades.EquiposAJugar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(Encuentro.class)
public class Encuentro_ { 

    public static volatile SingularAttribute<Encuentro, DisciplinaTorneo> disciplinaTorneo;
    public static volatile SingularAttribute<Encuentro, Arbitro> idArbitro;
    public static volatile SingularAttribute<Encuentro, Date> fecha;
    public static volatile SingularAttribute<Encuentro, Integer> idEncuentro;
    public static volatile ListAttribute<Encuentro, EquiposAJugar> equiposAJugarList;
    public static volatile SingularAttribute<Encuentro, Cancha> idCancha;

}