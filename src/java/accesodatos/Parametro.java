/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesodatos;

/**
 *
 * @author Paul Paguay
 */
public class Parametro {
    private int posicion;
    private Object valor;
    private int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    public Parametro()
    {
    posicion=0;
    valor= null;
    }

    public Parametro(int posicion, Object valor)
    {
    this.posicion=posicion;
    this.valor= valor;
    }

    public Parametro(int posicion, Object valor, int tipo) {
        this.posicion = posicion;
        this.valor = valor;
        this.tipo = tipo;
    }

    
    
    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the valor
     */
    public Object getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Object valor) {
        this.valor = valor;
    }
    


}
