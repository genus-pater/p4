package entidades;

import entidades.Menu;
import entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-11T21:19:34")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, Boolean> estado;
    public static volatile SingularAttribute<Menu, String> tipo;
    public static volatile SingularAttribute<Menu, String> ruta;
    public static volatile ListAttribute<Menu, Menu> menuList;
    public static volatile SingularAttribute<Menu, Integer> idMenu;
    public static volatile SingularAttribute<Menu, Rol> idRol;
    public static volatile SingularAttribute<Menu, Menu> idMenuPadre;

}