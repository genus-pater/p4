package entidades;

import entidades.Encuentro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-13T16:15:20")
@StaticMetamodel(Cancha.class)
public class Cancha_ { 

    public static volatile SingularAttribute<Cancha, String> ubicacion;
    public static volatile SingularAttribute<Cancha, Integer> idCancha;
    public static volatile ListAttribute<Cancha, Encuentro> encuentroList;

}