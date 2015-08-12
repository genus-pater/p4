package entidades;

import entidades.Encuentro;
import entidades.EquiposAJugarPK;
import entidades.Inscripcion;
import entidades.Partido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(EquiposAJugar.class)
public class EquiposAJugar_ { 

    public static volatile SingularAttribute<EquiposAJugar, Inscripcion> inscripcion;
    public static volatile ListAttribute<EquiposAJugar, Partido> partidoList;
    public static volatile SingularAttribute<EquiposAJugar, Integer> numeroParticipante;
    public static volatile SingularAttribute<EquiposAJugar, EquiposAJugarPK> equiposAJugarPK;
    public static volatile SingularAttribute<EquiposAJugar, Encuentro> encuentro;

}