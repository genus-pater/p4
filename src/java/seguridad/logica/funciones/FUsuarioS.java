/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
/*import consumoServicio.ConsumoWeb;
import ec.edu.espoch.academico.ArrayOfDictadoMateria;
import ec.edu.espoch.academico.ArrayOfHorarioClase;
import ec.edu.espoch.academico.ArrayOfMateriaPensum;
import ec.edu.espoch.academico.ArrayOfMateriaRequisito;
import ec.edu.espoch.academico.ArrayOfTitulosDocente;
import ec.edu.espoch.academico.DictadoMateria;
import ec.edu.espoch.academico.HorarioClase;
import ec.edu.espoch.academico.MateriaPensum;
import ec.edu.espoch.academico.MateriaRequisito;
import ec.edu.espoch.academico.Periodo;
import ec.edu.espoch.academico.Persona;
import ec.edu.espoch.academico.TitulosDocente;
import ec.edu.espoch.academico.UnidadAcademica;
*/
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import seguridad.logica.clases.Rol;
import seguridad.logica.clases.Usuario;
import seguridad.logica.clases.UsuarioRol;
import seguridad.logica.clases.UsuarioS;
//import static seguridad.logica.funciones.FUsuario.llenarFacEscCarr;

/**
 *
 * @author VargasJoffre
 */
public class FUsuarioS {

    public static boolean cambiarpass(UsuarioS usuario, String ci) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from silabo_seguridad.f_select_usuario_dado_ci_pass(?,?)";
            lstP.add(new Parametro(1, ci));
            lstP.add(new Parametro(2, usuario.getPass()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            if(rs.next()) {
                ArrayList<Parametro> lstP2 = new ArrayList<Parametro>();
                    String sql2 = "select * from silabo_seguridad.f_update_pass(?,?)";
                    lstP2.add(new Parametro(1, usuario.getNpass()));
                    lstP2.add(new Parametro(2, ci));
                    ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql2, lstP2);
                    if (rs2.next()) {
                            eje = true;
                    }
            }

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

}
