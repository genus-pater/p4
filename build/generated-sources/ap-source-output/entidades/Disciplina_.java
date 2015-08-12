package entidades;

import entidades.DisciplinaTorneo;
import entidades.Marcador;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-12T08:13:10")
@StaticMetamodel(Disciplina.class)
public class Disciplina_ { 

    public static volatile SingularAttribute<Disciplina, Boolean> estado;
    public static volatile SingularAttribute<Disciplina, Integer> idDiscilina;
    public static volatile SingularAttribute<Disciplina, Double> costo;
    public static volatile ListAttribute<Disciplina, Marcador> marcadorList;
    public static volatile ListAttribute<Disciplina, DisciplinaTorneo> disciplinaTorneoList;
    public static volatile SingularAttribute<Disciplina, String> nombre;

}