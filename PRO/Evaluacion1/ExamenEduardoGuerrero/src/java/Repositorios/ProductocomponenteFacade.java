/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Productocomponente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author edu7g
 */
@Stateless
public class ProductocomponenteFacade extends AbstractFacade<Productocomponente> {

    @PersistenceContext(unitName = "ExamenEduardoGuerreroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductocomponenteFacade() {
        super(Productocomponente.class);
    }
    
}
