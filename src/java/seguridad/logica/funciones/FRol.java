/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import seguridad.logica.clases.*;

/**
 *
 * @author Miguel Mejia
 */
public class FRol {

    public static int Insertar(Rol rol) throws Exception {
        int eje = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from f_insert_rol(?,?,?,?)";
            lstP.add(new Parametro(1, rol.getNombre()));
            lstP.add(new Parametro(2, rol.getDescripcion()));
            lstP.add(new Parametro(3, rol.getEstado()));
            //lstP.add(new Parametro(4, rol.getCodigo_modulo().getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getInt(0) > 0) {
                    eje = rs.getInt(0);
                }
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean Actualizar(Rol rol) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from f_update_rol(?,?,?,?,?)";
            lstP.add(new Parametro(1, rol.getNombre()));
            lstP.add(new Parametro(2, rol.getDescripcion()));
            lstP.add(new Parametro(3, rol.getEstado()));
            //lstP.add(new Parametro(4, rol.getCodigo_modulo().getCodigo()));
            lstP.add(new Parametro(5, rol.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"))
                eje = true;
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
            String sql = "select * from f_delete_rol(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"))
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
}
