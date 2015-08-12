/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author Diego
 */
public class Validaciones {

    private String fnumero;

    public static int EvaluarCaracter(char Caracter) {
        return (int) Caracter - 48;
    }

    public Validaciones(String numero) {
        this.fnumero = numero;

    }

    public static boolean ValidarNumeros(String NumeroCedula) {
        try {
            boolean blnValida = true;

            for (int i = 0; i <= 8; i++) {
                if (!Character.isDigit(NumeroCedula.charAt(i))) {
                    blnValida = false;
                }
            }
            if (!(Character.isDigit(NumeroCedula.charAt(10)))) {
                blnValida = false;
            }
            return blnValida;
        } catch (Exception e) {
//				Errores err = new Errores();
//				err.SetError(fUbicacion, "Cedula", "private bool ValidarNumeros(string NumeroCedula)",e.Message);
            return false;
        }
    }

    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    /**
     * @return the fnumero
     */
    public String getFnumero() {
        return fnumero;
    }

    /**
     * @param fnumero the fnumero to set
     */
    public void setFnumero(String fnumero) {
        this.fnumero = fnumero;
    }
}
