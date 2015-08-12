/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import entidades.oasis;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author eborja
 */
@ManagedBean
@RequestScoped
public class Coasis {

    private String codigo;
    private oasis objO;

    /**
     * Creates a new instance of oasis
     */
    public Coasis() {
        codigo = "";
        objO = new oasis();
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the objO
     */
    public oasis getObjO() {
        return objO;
    }

    /**
     * @param objO the objO to set
     */
    public void setObjO(oasis objO) {
        this.objO = objO;
    }

    public void buscar() throws Exception {
        ConjuntoResultado con = AccesoDatos.ejecutaQuery("select * from estudiantesoasis where cedula~'" + codigo+"'");
        while (con.next()) {
            objO = new oasis(con.getString(0), con.getString(1), con.getString(2), con.getInt(3), con.getString(4));
        }
    }

}
