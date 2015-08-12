package modelos;

import entidades.JugadorEquipo;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.JugadorEquipoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "jugadorEquipoController")
@SessionScoped
public class JugadorEquipoController implements Serializable {

    @EJB
    private controladores.JugadorEquipoFacade ejbFacade;
    private List<JugadorEquipo> items = null;
    private JugadorEquipo selected;
    private JugadorEquipo selected2;

    public JugadorEquipoController() {
        selected2=new JugadorEquipo();
    }

    public JugadorEquipo getSelected() {
        return selected;
    }

    public void setSelected(JugadorEquipo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getJugadorEquipoPK().setIdEquipo(selected.getEquipo().getIdEquipo());
        selected.getJugadorEquipoPK().setIdJugador(selected.getJugador().getIdJugador());
    }

    protected void initializeEmbeddableKey() {
        selected.setJugadorEquipoPK(new entidades.JugadorEquipoPK());
    }

    private JugadorEquipoFacade getFacade() {
        return ejbFacade;
    }

    public JugadorEquipo prepareCreate() {
        selected = new JugadorEquipo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("JugadorEquipoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("JugadorEquipoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("JugadorEquipoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<JugadorEquipo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<JugadorEquipo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<JugadorEquipo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /**
     * @return the selected2
     */
    public JugadorEquipo getSelected2() {
        return selected2;
    }

    /**
     * @param selected2 the selected2 to set
     */
    public void setSelected2(JugadorEquipo selected2) {
        this.selected2 = selected2;
    }

    @FacesConverter(forClass = JugadorEquipo.class)
    public static class JugadorEquipoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            JugadorEquipoController controller = (JugadorEquipoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "jugadorEquipoController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.JugadorEquipoPK getKey(String value) {
            entidades.JugadorEquipoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.JugadorEquipoPK();
            key.setIdJugador(Integer.parseInt(values[0]));
            key.setIdEquipo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entidades.JugadorEquipoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdJugador());
            sb.append(SEPARATOR);
            sb.append(value.getIdEquipo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof JugadorEquipo) {
                JugadorEquipo o = (JugadorEquipo) object;
                return getStringKey(o.getJugadorEquipoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), JugadorEquipo.class.getName()});
                return null;
            }
        }

    }

}
