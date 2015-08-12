package modelos;

import entidades.Clasificatoria;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.ClasificatoriaFacade;

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

@ManagedBean(name = "clasificatoriaController")
@SessionScoped
public class ClasificatoriaController implements Serializable {

    @EJB
    private controladores.ClasificatoriaFacade ejbFacade;
    private List<Clasificatoria> items = null;
    private Clasificatoria selected;

    public ClasificatoriaController() {
    }

    public Clasificatoria getSelected() {
        return selected;
    }

    public void setSelected(Clasificatoria selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getClasificatoriaPK().setIdTipoClasificatoria(selected.getTipoClasificatoria().getIdTipoClasificatoria());
        selected.getClasificatoriaPK().setIdTorneo(selected.getInscripcion().getInscripcionPK().getIdTorneo());
        selected.getClasificatoriaPK().setIdEquipo(selected.getInscripcion().getInscripcionPK().getIdEquipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setClasificatoriaPK(new entidades.ClasificatoriaPK());
    }

    private ClasificatoriaFacade getFacade() {
        return ejbFacade;
    }

    public Clasificatoria prepareCreate() {
        selected = new Clasificatoria();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ClasificatoriaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ClasificatoriaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ClasificatoriaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Clasificatoria> getItems() {
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

    public List<Clasificatoria> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Clasificatoria> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Clasificatoria.class)
    public static class ClasificatoriaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClasificatoriaController controller = (ClasificatoriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clasificatoriaController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.ClasificatoriaPK getKey(String value) {
            entidades.ClasificatoriaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.ClasificatoriaPK();
            key.setIdClasificatoria(Integer.parseInt(values[0]));
            key.setIdTipoClasificatoria(Integer.parseInt(values[1]));
            key.setIdTorneo(Integer.parseInt(values[2]));
            key.setIdEquipo(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(entidades.ClasificatoriaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdClasificatoria());
            sb.append(SEPARATOR);
            sb.append(value.getIdTipoClasificatoria());
            sb.append(SEPARATOR);
            sb.append(value.getIdTorneo());
            sb.append(SEPARATOR);
            sb.append(value.getIdEquipo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Clasificatoria) {
                Clasificatoria o = (Clasificatoria) object;
                return getStringKey(o.getClasificatoriaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Clasificatoria.class.getName()});
                return null;
            }
        }

    }

}
