/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Lineapcliente;
import Entidades.Productopropio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edu7g
 */
@Stateless
public class LineapclienteFacade extends AbstractFacade<Lineapcliente> {

    @PersistenceContext(unitName = "ExamenEduardoGuerreroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineapclienteFacade() {
        super(Lineapcliente.class);
    }
    
    public List<Lineapcliente> componentes_por_producto(Productopropio producto){
        EntityManager em = getEntityManager();
        Query q;
        if(producto != null){
            q = em.createNamedQuery("Lineapcliente.findByProducto").setParameter("codProducto", producto);
            return q.getResultList();
        }
        return null;
    }  
    
}
