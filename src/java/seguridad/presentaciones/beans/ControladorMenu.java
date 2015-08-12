/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.presentaciones.beans;

import entidades.Menu;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import controladores.MenuFacade;

/**
 *
 * @author eborja
 */
@ManagedBean
@RequestScoped
public class ControladorMenu {

    @EJB
    private MenuFacade EJBMenu;
    private List<Menu> lisMenus;
    private MenuModel objMenuModel;

    /**
     * Creates a new instance of ControladorMenu
     */
    public ControladorMenu() {
    }

    @PostConstruct
    public void init() {
        this.listarMenu();
        this.setObjMenuModel(new DefaultMenuModel());
        this.establecerPermisos();
    }

    public void listarMenu() {
        try {
            setLisMenus(getEJBMenu().findAll());
        } catch (Exception e) {
            //mensaje jsf
        }
    }

    public void establecerPermisos() {
        for (Menu m : getLisMenus()) {
            if (m.getTipo().equals("SubMenu") && verificar(m)) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                for (Menu i : getLisMenus()) {
                    Menu subMenu = i.getIdMenuPadre();
                    if (subMenu != null) {
                        if (Objects.equals(subMenu.getIdMenu(), m.getIdMenu())) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            //item.setUpdate(":paginas");
                            //item.setUrl(i.getTmenuruta());
                            item.setAjax(true);
                            item.setOutcome(i.getRuta());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                getObjMenuModel().addElement(firstSubmenu);
            } else {
                if (m.getIdMenuPadre() == null && verificar(m)) {
                    DefaultSubMenu item = new DefaultSubMenu(m.getNombre());
                    getObjMenuModel().addElement(item);
                }
            }
        }
    }

    public boolean verificar(Menu obj) {
        boolean res = false;
        SesionUsuarioDataManager sesion = (SesionUsuarioDataManager) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sesionUsuarioDataManager");
        if (sesion.getSesionUsuarioRolActual().getCodigo() == obj.getIdRol().getCodigo()) {
            res = true;
        }
        return res;
    }

    

    /**
     * @return the EJBMenu
     */
    public MenuFacade getEJBMenu() {
        return EJBMenu;
    }

    /**
     * @param EJBMenu the EJBMenu to set
     */
    public void setEJBMenu(MenuFacade EJBMenu) {
        this.EJBMenu = EJBMenu;
    }

    /**
     * @return the lisMenus
     */
    public List<Menu> getLisMenus() {
        return lisMenus;
    }

    /**
     * @param lisMenus the lisMenus to set
     */
    public void setLisMenus(List<Menu> lisMenus) {
        this.lisMenus = lisMenus;
    }

    /**
     * @return the objMenuModel
     */
    public MenuModel getObjMenuModel() {
        return objMenuModel;
    }

    /**
     * @param objMenuModel the objMenuModel to set
     */
    public void setObjMenuModel(MenuModel objMenuModel) {
        this.objMenuModel = objMenuModel;
    }

}
