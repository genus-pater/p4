package recursos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

@ManagedBean(name = "util")
@SessionScoped
public class Util {

    private static boolean primerIngreso = false;

    public static boolean isPrimerIngreso() {
        return primerIngreso;
    }

    public static void setPrimerIngreso(boolean primerIngreso) {
        Util.primerIngreso = primerIngreso;
    }

    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static void addErrorFatalMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static void addWarningMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = Util.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }

    public static void mostrarMensaje(String msj) {
        if (msj != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta!!", msj);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public static void getMensajePropietes(String key) {
        try {
            Properties info = new Properties();
            info.load(Util.class.getResourceAsStream("/recursos/mensajesSeguridad.properties"));
            String mens = info.getProperty(key);
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mens, mens);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
        }
    }

    public static void getMensajePropietesInfo(String key) {
        try {
            Properties info = new Properties();
            info.load(Util.class.getResourceAsStream("/recursos/mensajesSeguridad.properties"));
            String mens = info.getProperty(key);
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, mens, mens);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
        }
    }

    public static String obtenerFechString(long fecha) {
        java.util.Date fec = new Date(fecha);
        DateFormat formatear;
        formatear = new SimpleDateFormat("dd-MM-yyyy");
        String date = formatear.format(fec);
        return date;
    }
}