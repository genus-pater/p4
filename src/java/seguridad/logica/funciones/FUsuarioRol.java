/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.funciones;

import accesodatos.*;
import java.sql.SQLException;
import java.util.ArrayList;
import seguridad.logica.clases.Rol;
import seguridad.logica.clases.UsuarioRol;

/**
 *
 * @author VargasJoffre
 */
public class FUsuarioRol {

    private static boolean existeusuariorol(UsuarioRol usuariorol) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_select_usuarios_rol_dado_rol_y_usuario(?,?)";
            lstP.add(new Parametro(1, usuariorol.getCodigo_rol().getCodigo()));
            lstP.add(new Parametro(2, usuariorol.getCodigo_usuario().getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            if (rs.next()) {
                eje = true;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return eje;
    }

    public static boolean Insertar(UsuarioRol ur) throws Exception {
        boolean eje = false;
        try {
            if (existeusuariorol(ur)) {
                eje = false;
            } else {
                ArrayList<Parametro> lstP = new ArrayList<Parametro>();
                String sql = "select * from silabo_seguridad.f_insert_usuario_rol(?,?,?,?,?,?)";
                lstP.add(new Parametro(1, ur.getCodigo_rol().getCodigo()));
                lstP.add(new Parametro(2, ur.getCodigo_usuario().getCodigo()));
                lstP.add(new Parametro(3, ur.getEstado()));
                lstP.add(new Parametro(4, ur.getFecha_creacion()));
                lstP.add(new Parametro(5, ur.getFecha_modificacion()));
                lstP.add(new Parametro(6, ur.getCodigo_usuario_trans().getCodigo()));
                ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
                while (rs.next()) {
                    if (rs.getString(0).equals("true")) {
                        eje = true;
                    }
                }
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean Actualizar(UsuarioRol ur) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_update_usuario_rol(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, ur.getCodigo_rol().getCodigo()));
            lstP.add(new Parametro(2, ur.getCodigo_usuario().getCodigo()));
            lstP.add(new Parametro(3, ur.getEstado()));
            lstP.add(new Parametro(4, ur.getFecha_creacion()));
            lstP.add(new Parametro(5, ur.getFecha_modificacion()));
            lstP.add(new Parametro(6, ur.getCodigo_usuario_trans().getCodigo()));
            lstP.add(new Parametro(7, ur.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true")) {
                    eje = true;
                }
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean Eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_delete_usuario_rol(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true")) {
                    eje = true;
                }
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static ArrayList<UsuarioRol> ObtenerRolesDadoUsuario(String ci) throws Exception {
        ArrayList<UsuarioRol> lst = new ArrayList<UsuarioRol>();
        UsuarioRol rr = new UsuarioRol();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from usuario where cedula = ?;";
            lstP.add(new Parametro(1, ci));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            if (rs.next()) {
                rr.setCodigo(rs.getInt(7));
                lst.add(rr);
            } else {
                throw new Exception("Credenciales Incorrectas");
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
