package modelos;

import entidades.Marcador;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.MarcadorFacade;

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

@ManagedBean(name = "marcadorController")
@SessionScoped
public class MarcadorController implements Serializable {

    @EJB
    private controladores.MarcadorFacade ejbFacade;
    private List<Marcador> items = null;
    private Marcador selected;

    public MarcadorController() {
    }

    public Marcador getSelected() {
        return selected;
    }

    public void setSelected(Marcador selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getMarcadorPK().setIdDisciplina(selected.getDisciplina().getIdDiscilina());
    }

    protected void initializeEmbeddableKey() {
        selected.setMarcadorPK(new entidades.MarcadorPK());
    }

    private MarcadorFacade getFacade() {
        return ejbFacade;
    }

    public Marcador prepareCreate() {
        selected = new Marcador();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MarcadorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MarcadorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MarcadorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Marcador> getItems() {
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

    public List<Marcador> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Marcador> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Marcador.class)
    public static class MarcadorControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MarcadorController controller = (MarcadorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "marcadorController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.MarcadorPK getKey(String value) {
            entidades.MarcadorPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.MarcadorPK();
            key.setIdMarcador(Integer.parseInt(values[0]));
            key.setIdDisciplina(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entidades.MarcadorPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdMarcador());
            sb.append(SEPARATOR);
            sb.append(value.getIdDisciplina());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Marcador) {
                Marcador o = (Marcador) object;
                return getStringKey(o.getMarcadorPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Marcador.class.getName()});
                return null;
            }
        }

    }

}
