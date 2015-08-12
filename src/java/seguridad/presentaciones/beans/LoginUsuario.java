/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.presentaciones.beans;

//import ec.edu.espoch.academico.Periodo;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import seguridad.logica.clases.Usuario;
import seguridad.logica.funciones.*;
import recursos.Util;
import seguridad.logica.clases.Rol;

/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class LoginUsuario {

    Usuario usuario;
    private String clave;
    private String tipo_usuario;

    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    public LoginUsuario() {
        usuario = new Usuario();
        this.tipo_usuario = "";
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String login() {
        ResourceBundle recurso = ResourceBundle.getBundle("/recursos/mensajesSeguridad");
        try {
            Rol rol = FUsuario.autenticarUsuarioIndividual(this.usuario.getCi(), clave);
            // Rol5

            this.dm.setSesionUsuario((Usuario) FUsuario.ObtenerUsuarioDadoCi(this.usuario.getCi()));
            this.dm.setSesionUsuarioRoles(FUsuarioRol.ObtenerRolesDadoUsuario(this.dm.getSesionUsuario().getCi()));
            this.dm.setSesionUsuarioRolActual(rol);
            this.dm.setValidado(Boolean.TRUE);
            if (this.dm.getSesionUsuarioRoles().isEmpty()) {
                Util.addErrorMessage("El usuario no tiene perfiles asignados, comuniquese con el administrador del sistema");
                return "/login?faces-redirect=true";
            }
            return "/index?faces-redirect=true";
        } catch (Exception e) {
            Util.addErrorMessage(e, String.format(recurso.getString("errorCatch"), "Autentificacion"));
            return "/login?faces-redirect=true";
        }
    }

    public String cerrarSesion() {
        this.dm.destroy();
        return "/indexlogin.xhtml?faces-redirect=true";
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

}
