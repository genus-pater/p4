package modelos;

import entidades.EquiposAJugar;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.EquiposAJugarFacade;

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

@ManagedBean(name = "equiposAJugarController")
@SessionScoped
public class EquiposAJugarController implements Serializable {

    @EJB
    private controladores.EquiposAJugarFacade ejbFacade;
    private List<EquiposAJugar> items = null;
    private EquiposAJugar selected;

    public EquiposAJugarController() {
    }

    public EquiposAJugar getSelected() {
        return selected;
    }

    public void setSelected(EquiposAJugar selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEquiposAJugarPK().setIdEncuentro(selected.getEncuentro().getIdEncuentro());
        selected.getEquiposAJugarPK().setIdTorneo(selected.getInscripcion().getInscripcionPK().getIdTorneo());
        selected.getEquiposAJugarPK().setIdDisciplina(selected.getInscripcion().getInscripcionPK().getIdDisciplina());
        selected.getEquiposAJugarPK().setIdEquipo(selected.getInscripcion().getInscripcionPK().getIdEquipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setEquiposAJugarPK(new entidades.EquiposAJugarPK());
    }

    private EquiposAJugarFacade getFacade() {
        return ejbFacade;
    }

    public EquiposAJugar prepareCreate() {
        selected = new EquiposAJugar();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EquiposAJugarCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EquiposAJugarUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EquiposAJugarDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EquiposAJugar> getItems() {
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

    public List<EquiposAJugar> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EquiposAJugar> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EquiposAJugar.class)
    public static class EquiposAJugarControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EquiposAJugarController controller = (EquiposAJugarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "equiposAJugarController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.EquiposAJugarPK getKey(String value) {
            entidades.EquiposAJugarPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.EquiposAJugarPK();
            key.setIdEquiposAJugar(Integer.parseInt(values[0]));
            key.setIdEncuentro(Integer.parseInt(values[1]));
            key.setIdEquipo(Integer.parseInt(values[2]));
            key.setIdDisciplina(Integer.parseInt(values[3]));
            key.setIdTorneo(Integer.parseInt(values[4]));
            return key;
        }

        String getStringKey(entidades.EquiposAJugarPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEquiposAJugar());
            sb.append(SEPARATOR);
            sb.append(value.getIdEncuentro());
            sb.append(SEPARATOR);
            sb.append(value.getIdEquipo());
            sb.append(SEPARATOR);
            sb.append(value.getIdDisciplina());
            sb.append(SEPARATOR);
            sb.append(value.getIdTorneo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EquiposAJugar) {
                EquiposAJugar o = (EquiposAJugar) object;
                return getStringKey(o.getEquiposAJugarPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EquiposAJugar.class.getName()});
                return null;
            }
        }

    }

}
