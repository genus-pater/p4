package modelos;

import entidades.JugadorEquipoSancion;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.JugadorEquipoSancionFacade;

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

@ManagedBean(name = "jugadorEquipoSancionController")
@SessionScoped
public class JugadorEquipoSancionController implements Serializable {

    @EJB
    private controladores.JugadorEquipoSancionFacade ejbFacade;
    private List<JugadorEquipoSancion> items = null;
    private JugadorEquipoSancion selected;

    public JugadorEquipoSancionController() {
    }

    public JugadorEquipoSancion getSelected() {
        return selected;
    }

    public void setSelected(JugadorEquipoSancion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getJugadorEquipoSancionPK().setIdJugador(selected.getJugadorEquipo().getJugadorEquipoPK().getIdJugador());
        selected.getJugadorEquipoSancionPK().setIdSancion(selected.getSancion().getIdSancion());
        selected.getJugadorEquipoSancionPK().setIdEquipo(selected.getJugadorEquipo().getJugadorEquipoPK().getIdEquipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setJugadorEquipoSancionPK(new entidades.JugadorEquipoSancionPK());
    }

    private JugadorEquipoSancionFacade getFacade() {
        return ejbFacade;
    }

    public JugadorEquipoSancion prepareCreate() {
        selected = new JugadorEquipoSancion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("JugadorEquipoSancionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("JugadorEquipoSancionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("JugadorEquipoSancionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<JugadorEquipoSancion> getItems() {
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

    public List<JugadorEquipoSancion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<JugadorEquipoSancion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = JugadorEquipoSancion.class)
    public static class JugadorEquipoSancionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            JugadorEquipoSancionController controller = (JugadorEquipoSancionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "jugadorEquipoSancionController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.JugadorEquipoSancionPK getKey(String value) {
            entidades.JugadorEquipoSancionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.JugadorEquipoSancionPK();
            key.setIdJugadorEquipoSancion(Integer.parseInt(values[0]));
            key.setIdJugador(Integer.parseInt(values[1]));
            key.setIdEquipo(Integer.parseInt(values[2]));
            key.setIdSancion(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(entidades.JugadorEquipoSancionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdJugadorEquipoSancion());
            sb.append(SEPARATOR);
            sb.append(value.getIdJugador());
            sb.append(SEPARATOR);
            sb.append(value.getIdEquipo());
            sb.append(SEPARATOR);
            sb.append(value.getIdSancion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof JugadorEquipoSancion) {
                JugadorEquipoSancion o = (JugadorEquipoSancion) object;
                return getStringKey(o.getJugadorEquipoSancionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), JugadorEquipoSancion.class.getName()});
                return null;
            }
        }

    }

}
