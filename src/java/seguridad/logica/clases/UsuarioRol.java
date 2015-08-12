/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.clases;

/**
 *
 * @author VargasJoffre
 */
public class UsuarioRol {
   private int codigo;
  private Rol codigo_rol;
  private Usuario codigo_usuario;
  private int estado;
  private long fecha_creacion;
  private long fecha_modificacion;
  private Usuario codigo_usuario_trans;

    public UsuarioRol() {
    }

    public UsuarioRol(int codigo, Rol codigo_rol, Usuario codigo_usuario, int estado, long fecha_creacion, long fecha_modificacion, Usuario codigo_usuario_trans) {
        this.codigo = codigo;
        this.codigo_rol = codigo_rol;
        this.codigo_usuario = codigo_usuario;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.codigo_usuario_trans = codigo_usuario_trans;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigo_rol
     */
    public Rol getCodigo_rol() {
        return codigo_rol;
    }

    /**
     * @param codigo_rol the codigo_rol to set
     */
    public void setCodigo_rol(Rol codigo_rol) {
        this.codigo_rol = codigo_rol;
    }

    /**
     * @return the codigo_usuario
     */
    public Usuario getCodigo_usuario() {
        return codigo_usuario;
    }

    /**
     * @param codigo_usuario the codigo_usuario to set
     */
    public void setCodigo_usuario(Usuario codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
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
     * @return the fecha_creacion
     */
    public long getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * @param fecha_creacion the fecha_creacion to set
     */
    public void setFecha_creacion(long fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * @return the fecha_modificacion
     */
    public long getFecha_modificacion() {
        return fecha_modificacion;
    }

    /**
     * @param fecha_modificacion the fecha_modificacion to set
     */
    public void setFecha_modificacion(long fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    /**
     * @return the codigo_usuario_trans
     */
    public Usuario getCodigo_usuario_trans() {
        return codigo_usuario_trans;
    }

    /**
     * @param codigo_usuario_trans the codigo_usuario_trans to set
     */
    public void setCodigo_usuario_trans(Usuario codigo_usuario_trans) {
        this.codigo_usuario_trans = codigo_usuario_trans;
    }
}

   
   
   


