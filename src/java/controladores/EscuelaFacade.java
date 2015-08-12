/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Escuela;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eborja
 */
@Stateless
public class EscuelaFacade extends AbstractFacade<Escuela> {
    @PersistenceContext(unitName = "HUNJPAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EscuelaFacade() {
        super(Escuela.class);
    }
    
}
