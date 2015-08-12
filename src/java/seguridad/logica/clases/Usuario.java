/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.clases;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import sun.misc.MessageUtils;

/**
 *
 * @author VargasJoffre
 */
public class Usuario {

    private long codigo;
    private int estado;
    private String ci;
    private String nombres;
    private String apellidos;
    private String mail;
    private String telefono1;
    private String telefono2;
    private String tituloTercerNivel;
    private String tituloPostgrado;
    private String codtitulo;
    private String pass;

    public Usuario() {
        this.codigo = 0;
        this.estado = 0;
        this.ci = "";
        this.nombres = "";
        this.apellidos = "";
        this.mail = "";
        this.telefono1 = "";
        this.telefono2 = "";
        this.tituloTercerNivel = "";
        this.tituloPostgrado = "";
        this.codtitulo = "";
    }

    public Usuario(long codigo, int estado, String ci, String nombres, String apellidos, String mail,
            String tipo_usuario) {
        this.codigo = codigo;
        this.estado = estado;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.mail = mail;
        this.telefono1 = tipo_usuario;
        this.telefono2 = "0";
        this.tituloTercerNivel = "0";
        this.tituloPostgrado = "0";
        this.codtitulo = "0";
    }

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the ci
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(String ci) {
        this.ci = ci;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the telefono1
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * @param telefono1 the telefono1 to set
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * @return the telefono2
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * @param telefono2 the telefono2 to set
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * @return the tituloTercerNivel
     */
    public String getTituloTercerNivel() {
        return tituloTercerNivel;
    }

    /**
     * @param tituloTercerNivel the tituloTercerNivel to set
     */
    public void setTituloTercerNivel(String tituloTercerNivel) {
        this.tituloTercerNivel = tituloTercerNivel;
    }

    /**
     * @return the tituloPostgrado
     */
    public String getTituloPostgrado() {
        return tituloPostgrado;
    }

    /**
     * @param tituloPostgrado the tituloPostgrado to set
     */
    public void setTituloPostgrado(String tituloPostgrado) {
        this.tituloPostgrado = tituloPostgrado;
    }

    public String getCodtitulo() {
        return codtitulo;
    }

    public String getpass() {
        return pass;
    }

    public void setCodtitulo(String codtitulo) {
        this.codtitulo = codtitulo;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String password) {
        this.pass = password;
    }

}
