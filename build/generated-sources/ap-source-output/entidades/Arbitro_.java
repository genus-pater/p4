package entidades;

import entidades.Encuentro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(Arbitro.class)
public class Arbitro_ { 

    public static volatile SingularAttribute<Arbitro, String> nombre;
    public static volatile SingularAttribute<Arbitro, String> apellido;
    public static volatile SingularAttribute<Arbitro, Integer> idArbitro;
    public static volatile ListAttribute<Arbitro, Encuentro> encuentroList;

}