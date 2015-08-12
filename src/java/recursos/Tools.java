/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author PAUL
 */
public class Tools {
     public static String obtienefechaImpresion(Date fecha){
		 String retorno="";
		 SimpleDateFormat dateFormatter = new SimpleDateFormat(
                         recursos.Global.getParametroString("formatofechaimpresion"), new Locale("es","ES"));;
		 try {			
			 retorno=dateFormatter.format(fecha.getTime());			
		} catch (Exception e) {
			retorno="";
		}		 
	    return retorno;
	 }
      public static String obtienefechaImpresion(Date fecha, String formato){
		 String retorno="";
		 SimpleDateFormat dateFormatter = new SimpleDateFormat(
                         formato, new Locale("es","ES"));;
		 try {			
			 retorno=dateFormatter.format(fecha.getTime());			
		} catch (Exception e) {
			retorno="";
		}		 
	    return retorno;
	 }
      
       public static int obtieneDiferenciaHoras(Date horaI, Date horaF){            		
            long diff = horaF.getTime()- horaI.getTime() ;
            double diffInHours = diff / ((double) 1000 * 60 * 60); 	 
            if(diffInHours<0)
                diffInHours=0;                
	    return (int)diffInHours;
	 }
    public static int obtieneCodDiaInteger(String Coddia){
        int coddia=1;
        if(Coddia.equals("LUN"))
        {  coddia= 1;}
        else if (Coddia.equals("MAR"))
          {  coddia= 2;}
         else if (Coddia.equals("MIE"))
          {  coddia= 3;}
         else if (Coddia.equals("JUE"))
          {  coddia= 4;}
         else if (Coddia.equals("VIE"))
          {  coddia= 5;}
        return coddia;
    }
     
      public static Date obtieneDate(String fecha, String formato){
		 Date retorno=null;
		 SimpleDateFormat dateFormatter = new SimpleDateFormat(formato);
		 try {	
			 retorno=dateFormatter.parse(fecha);			
		} catch (Exception e) {
			retorno=null;
		}		 
	    return retorno;
	 }
      
     
}
