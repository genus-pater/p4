package modelos;

import entidades.Partido;
import modelos.util.JsfUtil;
import modelos.util.JsfUtil.PersistAction;
import controladores.PartidoFacade;

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

@ManagedBean(name = "partidoController")
@SessionScoped
public class PartidoController implements Serializable {

    @EJB
    private controladores.PartidoFacade ejbFacade;
    private List<Partido> items = null;
    private Partido selected;

    public PartidoController() {
    }

    public Partido getSelected() {
        return selected;
    }

    public void setSelected(Partido selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPartidoPK().setIdTorneo(selected.getEquiposAJugar().getEquiposAJugarPK().getIdTorneo());
        selected.getPartidoPK().setIdEquiposAJugar(selected.getEquiposAJugar().getEquiposAJugarPK().getIdEquiposAJugar());
        selected.getPartidoPK().setIdEquipo(selected.getEquiposAJugar().getEquiposAJugarPK().getIdEquipo());
        selected.getPartidoPK().setIdDisciplina(selected.getEquiposAJugar().getEquiposAJugarPK().getIdDisciplina());
        selected.getPartidoPK().setIdEncuentro(selected.getEquiposAJugar().getEquiposAJugarPK().getIdEncuentro());
    }

    protected void initializeEmbeddableKey() {
        selected.setPartidoPK(new entidades.PartidoPK());
    }

    private PartidoFacade getFacade() {
        return ejbFacade;
    }

    public Partido prepareCreate() {
        selected = new Partido();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PartidoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PartidoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PartidoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Partido> getItems() {
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

    public List<Partido> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Partido> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Partido.class)
    public static class PartidoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PartidoController controller = (PartidoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "partidoController");
            return controller.getFacade().find(getKey(value));
        }

        entidades.PartidoPK getKey(String value) {
            entidades.PartidoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.PartidoPK();
            key.setIdPartido(Integer.parseInt(values[0]));
            key.setIdEquiposAJugar(Integer.parseInt(values[1]));
            key.setIdEncuentro(Integer.parseInt(values[2]));
            key.setIdEquipo(Integer.parseInt(values[3]));
            key.setIdDisciplina(Integer.parseInt(values[4]));
            key.setIdTorneo(Integer.parseInt(values[5]));
            return key;
        }

        String getStringKey(entidades.PartidoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdPartido());
            sb.append(SEPARATOR);
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
            if (object instanceof Partido) {
                Partido o = (Partido) object;
                return getStringKey(o.getPartidoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Partido.class.getName()});
                return null;
            }
        }

    }

}
