/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.logica.funciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edison
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(verificaSemaActual(df.parse("8/6/2013")));
        } catch (Exception ex) {
            Logger.getLogger(NewMain2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static boolean verificaSemaActual(Date fech) throws Exception {

//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        boolean ban = false;
        if (fech.compareTo(new Date()) <= 0) {


            Date fechaIngre = null;
            try {
                fechaIngre = fech;
            } catch (Exception e) {
                throw e;
            }
            GregorianCalendar fechaCalendarioI = new GregorianCalendar();
            fechaCalendarioI.setTime(fechaIngre);
            int semanaIngre = fechaCalendarioI.get(Calendar.WEEK_OF_YEAR);


            GregorianCalendar fechaCalendario = new GregorianCalendar();
            fechaCalendario.setTime(new Date());
            int semanaActual = fechaCalendario.get(Calendar.WEEK_OF_YEAR);
            if (semanaIngre == semanaActual) {
                ban = true;
            }
        }
        return ban;
    }
}
