package modelos;

import entidades.Inscripcion;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.InscripcionFacade;

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

@ManagedBean(name = "inscripcionController")
@SessionScoped
public class InscripcionController implements Serializable {

    @EJB
    private controladores.InscripcionFacade ejbFacade;
    private List<Inscripcion> items = null;
    private Inscripcion selected;

    public InscripcionController() {
    }

    public Inscripcion getSelected() {
        return selected;
    }

    public void setSelected(Inscripcion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getInscripcionPK().setIdTorneo(selected.getDisciplinaTorneo().getDisciplinaTorneoPK().getIdTorneo());
        selected.getInscripcionPK().setIdDisciplina(selected.getDisciplinaTorneo().getDisciplinaTorneoPK().getIdDisciplina());
        selected.getInscripcionPK().setIdEquipo(selected.getEquipo().getIdEquipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setInscripcionPK(new entidades.InscripcionPK());
    }

    private InscripcionFacade getFacade() {
        return ejbFacade;
    }

    public Inscripcion prepareCreate() {
        selected = new Inscripcion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InscripcionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InscripcionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InscripcionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Inscripcion> getItems() {
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

    public List<Inscripcion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Inscripcion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Inscripcion.class)
    public static class InscripcionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InscripcionController controller = (InscripcionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inscripcionController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.InscripcionPK getKey(String value) {
            entidades.InscripcionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.InscripcionPK();
            key.setIdEquipo(Integer.parseInt(values[0]));
            key.setIdDisciplina(Integer.parseInt(values[1]));
            key.setIdTorneo(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(entidades.InscripcionPK value) {
            StringBuilder sb = new StringBuilder();
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
            if (object instanceof Inscripcion) {
                Inscripcion o = (Inscripcion) object;
                return getStringKey(o.getInscripcionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Inscripcion.class.getName()});
                return null;
            }
        }

    }

}
