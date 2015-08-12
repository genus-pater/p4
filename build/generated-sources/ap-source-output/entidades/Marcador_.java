package entidades;

import entidades.Disciplina;
import entidades.MarcadorPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-12T08:13:10")
@StaticMetamodel(Marcador.class)
public class Marcador_ { 

    public static volatile SingularAttribute<Marcador, String> descripcion;
    public static volatile SingularAttribute<Marcador, Disciplina> disciplina;
    public static volatile SingularAttribute<Marcador, MarcadorPK> marcadorPK;

}