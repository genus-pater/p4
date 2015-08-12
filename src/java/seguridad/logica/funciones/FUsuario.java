/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
/*import consumoServicio.ConsumoWeb;
 import ec.edu.espoch.academico.ArrayOfDictadoMateria;
 import ec.edu.espoch.academico.ArrayOfHorarioClase;
 import ec.edu.espoch.academico.ArrayOfMateriaPensum;
 import ec.edu.espoch.academico.ArrayOfMateriaRequisito;
 import ec.edu.espoch.academico.ArrayOfPeriodo;
 import ec.edu.espoch.academico.ArrayOfRolCarrera;
 import ec.edu.espoch.academico.ArrayOfTitulosDocente;
 import ec.edu.espoch.academico.DictadoMateria;
 import ec.edu.espoch.academico.Escuela;
 import ec.edu.espoch.academico.Facultad;
 import ec.edu.espoch.academico.HorarioClase;
 import ec.edu.espoch.academico.MateriaPensum;
 import ec.edu.espoch.academico.MateriaRequisito;
 import ec.edu.espoch.academico.Periodo;
 import ec.edu.espoch.academico.Persona;
 import ec.edu.espoch.academico.RolCarrera;
 import ec.edu.espoch.academico.TitulosDocente;
 import ec.edu.espoch.academico.UnidadAcademica;
 */
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import recursos.Tools;
import seguridad.logica.clases.Rol;
import seguridad.logica.clases.Usuario;
import seguridad.logica.clases.UsuarioRol;

/**
 *
 * @author VargasJoffre
 */
public class FUsuario {

    public static Usuario ObtenerUsuarioDadoCi(String ci) throws Exception {
        Usuario lst = null;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from usuario where cedula = ?";
            lstP.add(new Parametro(1, ci));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static long Insertar(Usuario usuario) throws Exception {
        long eje = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_insert_usuario(?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, usuario.getEstado()));
            lstP.add(new Parametro(2, usuario.getCi()));
            lstP.add(new Parametro(3, usuario.getNombres()));
            lstP.add(new Parametro(4, usuario.getApellidos()));
            lstP.add(new Parametro(5, usuario.getMail()));
            lstP.add(new Parametro(6, usuario.getTelefono1()));
            lstP.add(new Parametro(7, usuario.getTelefono2()));
            lstP.add(new Parametro(8, usuario.getTituloTercerNivel()));
            lstP.add(new Parametro(9, usuario.getTituloPostgrado()));
            lstP.add(new Parametro(10, usuario.getCodtitulo()));
            lstP.add(new Parametro(11, usuario.getpass()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getLong(0) > 0);
                eje = rs.getLong(0);
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean cambiarpass(Usuario usuario, String nuevo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_update_pass(?,?)";
            lstP.add(new Parametro(1, nuevo));
            lstP.add(new Parametro(2, usuario.getCi()));
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

    public static boolean Actualizar(Usuario usuario) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_update_usuario(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, usuario.getTelefono1()));
            lstP.add(new Parametro(2, usuario.getTelefono2()));
            lstP.add(new Parametro(3, usuario.getTituloPostgrado()));
            lstP.add(new Parametro(4, usuario.getCodigo()));
            lstP.add(new Parametro(5, usuario.getTituloTercerNivel()));
            lstP.add(new Parametro(6, usuario.getMail()));
            lstP.add(new Parametro(7, usuario.getCodtitulo()));
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

    //obtener por cedula
    public static Usuario ObtenerUsuarioDadoCodigo(long codigo) throws Exception {
        Usuario lst = null;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_select_usuario_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Usuario ObtenerUsuarioDadoCi_Perido(String ci, String per) throws Exception {
        Usuario lst = null;
        ArrayList<Parametro> lstP = null;
        try {
            lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_select_usuario_dado_ci_periodo(?,?)";
            lstP.add(new Parametro(1, ci));
            lstP.add(new Parametro(2, per));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Rol autenticarUsuarioIndividual(java.lang.String login, java.lang.String password) throws Exception {
        Rol rol = new Rol();
        String cedula = null;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "select * from usuario where cedula = ? and pass = ?;";
            lstP.add(new Parametro(1, login));
            lstP.add(new Parametro(2, password));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            if (rs.next()) {
                String sql2 = "select * from roles_usuario where usuario = ?;";
                ArrayList<Parametro> lstP2 = new ArrayList<>();
                lstP2.add(new Parametro(1, rs.getInt(0)));
                ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql2, lstP2);
                if (rs2.next()) {
                    rol.setCodigo(rs2.getInt(2));
                } else {
                    throw new Exception("Credenciales Incorrectas");
                }

            } else {
                throw new Exception("Credenciales Incorrectas");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rol;
    }

    public static ArrayList<Rol> llenarRoles(ConjuntoResultado rs) throws Exception {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        Rol rol = null;
        try {
            while (rs.next()) {
                rol = new Rol();
                rol.setNombre(rs.getString(0));
                lst.add(rol);
            }
            if (lst.isEmpty()) {
                lst.add(rol);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //LLENAR DATOS OBTENIDOS SERVICIOS WEB    
    public static ArrayList<Usuario> llenarUsuarios(ConjuntoResultado rs) throws Exception {
        ArrayList<Usuario> lst = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            while (rs.next()) {
                usuario = new Usuario(0, 0, rs.getString("cedula"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("tipo_usuario"));
                lst.add(usuario);
            }
            if (lst.isEmpty()) {
                lst.add(usuario);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static Usuario ObtenerUsuarioDadoNick(String nick) throws Exception {
        Usuario lst = null;
        return lst;
    }

    public static ArrayList<Usuario> ObtenerUsuarios() throws Exception {
        ArrayList<Usuario> lst = new ArrayList<Usuario>();
        try {
            String sql = "select * from silabo_seguridad.f_select_usuarios()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarUsuarios(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<String> getimgroles() throws Exception {
        ArrayList<String> imgroles = new ArrayList<String>();
        try {
            String sql = "select * from rol";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            while (rs.next()) {
                imgroles.add(rs.getString(2));
            }
            if (imgroles.isEmpty()) {
                imgroles.add("");
            }
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return imgroles;
    }
}
