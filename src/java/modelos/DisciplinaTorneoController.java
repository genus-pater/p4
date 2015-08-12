package modelos;

import entidades.DisciplinaTorneo;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.DisciplinaTorneoFacade;

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

@ManagedBean(name = "disciplinaTorneoController")
@SessionScoped
public class DisciplinaTorneoController implements Serializable {

    @EJB
    private controladores.DisciplinaTorneoFacade ejbFacade;
    private List<DisciplinaTorneo> items = null;
    private DisciplinaTorneo selected;

    public DisciplinaTorneoController() {
    }

    public DisciplinaTorneo getSelected() {
        return selected;
    }

    public void setSelected(DisciplinaTorneo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getDisciplinaTorneoPK().setIdTorneo(selected.getTorneo().getIdTorneo());
        selected.getDisciplinaTorneoPK().setIdDisciplina(selected.getDisciplina().getIdDiscilina());
    }

    protected void initializeEmbeddableKey() {
        selected.setDisciplinaTorneoPK(new entidades.DisciplinaTorneoPK());
    }

    private DisciplinaTorneoFacade getFacade() {
        return ejbFacade;
    }

    public DisciplinaTorneo prepareCreate() {
        selected = new DisciplinaTorneo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DisciplinaTorneoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DisciplinaTorneoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DisciplinaTorneoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DisciplinaTorneo> getItems() {
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

    public List<DisciplinaTorneo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DisciplinaTorneo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DisciplinaTorneo.class)
    public static class DisciplinaTorneoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DisciplinaTorneoController controller = (DisciplinaTorneoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "disciplinaTorneoController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.DisciplinaTorneoPK getKey(String value) {
            entidades.DisciplinaTorneoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.DisciplinaTorneoPK();
            key.setIdTorneo(Integer.parseInt(values[0]));
            key.setIdDisciplina(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entidades.DisciplinaTorneoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdTorneo());
            sb.append(SEPARATOR);
            sb.append(value.getIdDisciplina());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DisciplinaTorneo) {
                DisciplinaTorneo o = (DisciplinaTorneo) object;
                return getStringKey(o.getDisciplinaTorneoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DisciplinaTorneo.class.getName()});
                return null;
            }
        }

    }

}
