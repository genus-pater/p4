package entidades;

import entidades.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> codigo;
    public static volatile SingularAttribute<Rol, String> imagen;
    public static volatile SingularAttribute<Rol, String> descripcion;
    public static volatile ListAttribute<Rol, Menu> menuList;

}