package entidades;

import entidades.ClasificatoriaPK;
import entidades.EstadoClasificatoria;
import entidades.Inscripcion;
import entidades.TipoClasificatoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-13T16:15:20")
@StaticMetamodel(Clasificatoria.class)
public class Clasificatoria_ { 

    public static volatile SingularAttribute<Clasificatoria, String> descripcion;
    public static volatile SingularAttribute<Clasificatoria, Inscripcion> inscripcion;
    public static volatile SingularAttribute<Clasificatoria, TipoClasificatoria> tipoClasificatoria;
    public static volatile SingularAttribute<Clasificatoria, EstadoClasificatoria> idEstadoClasificatoria;
    public static volatile SingularAttribute<Clasificatoria, ClasificatoriaPK> clasificatoriaPK;

}