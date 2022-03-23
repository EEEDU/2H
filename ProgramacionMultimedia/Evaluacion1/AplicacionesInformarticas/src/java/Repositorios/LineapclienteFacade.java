/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Lineapcliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author edu7g
 */
@Stateless
public class LineapclienteFacade extends AbstractFacade<Lineapcliente> {

    @PersistenceContext(unitName = "AplicacionesInformarticas2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineapclienteFacade() {
        super(Lineapcliente.class);
    }
    
}
