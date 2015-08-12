/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author PAUL
 */
public class Global {
    public static String getParametroString(String key) {
        String resultado="";
        try {
            Properties info = new Properties();
            info.load(Util.class.getResourceAsStream("/recursos/parametrosglobales.properties"));
            resultado = info.getProperty(key);           
        } catch (Exception e) {
              System.out.println("Error recursos.Global-getParametroString:"+e.getMessage());
        }
        return resultado;
    }
    public static boolean getParametroBoolean(String key) {
        boolean respuesta=false;
        try {
            Properties info = new Properties();
            info.load(Util.class.getResourceAsStream("/recursos/parametrosglobales.properties"));
            String mens = info.getProperty(key);
            respuesta= Boolean.parseBoolean(mens);
        } catch (Exception e) {
            System.out.println("Error recursos.Global-getParametroBoolean:"+e.getMessage());
        }
        return respuesta;
    }
}
