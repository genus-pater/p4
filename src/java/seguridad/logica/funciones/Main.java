/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.funciones;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        try {
            Date fecha = new Date();
//            
//            String[] semana={"INICIO","DOM","LUN","MAR","MIE","JUE","VIE","SAB"};
//            
//            System.out.println(semana[obtenerDiaSemana(fecha)]);
            String[] semana={"INICIO","DOM","LUN","MAR","MIE","JUE","VIE","SAB"};
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int obtenerDiaSemana(Date d) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
}
