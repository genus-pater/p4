package entidades;

import entidades.Clasificatoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(EstadoClasificatoria.class)
public class EstadoClasificatoria_ { 

    public static volatile SingularAttribute<EstadoClasificatoria, Integer> idEstadoClasificatoria;
    public static volatile SingularAttribute<EstadoClasificatoria, String> descripcion;
    public static volatile ListAttribute<EstadoClasificatoria, Clasificatoria> clasificatoriaList;

}