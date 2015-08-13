package entidades;

import entidades.AnotacionPK;
import entidades.JugadorEquipo;
import entidades.Partido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-13T16:15:20")
@StaticMetamodel(Anotacion.class)
public class Anotacion_ { 

    public static volatile SingularAttribute<Anotacion, Double> cantidad;
    public static volatile SingularAttribute<Anotacion, JugadorEquipo> jugadorEquipo;
    public static volatile SingularAttribute<Anotacion, AnotacionPK> anotacionPK;
    public static volatile SingularAttribute<Anotacion, Partido> partido;
    public static volatile SingularAttribute<Anotacion, String> observacion;

}