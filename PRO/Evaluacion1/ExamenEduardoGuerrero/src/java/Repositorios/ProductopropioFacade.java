/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Componente;
import Entidades.Productocomponente;
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
public class ProductopropioFacade extends AbstractFacade<Productopropio> {

    @PersistenceContext(unitName = "ExamenEduardoGuerreroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductopropioFacade() {
        super(Productopropio.class);
    }
    public List<Productopropio> productos_ordenados(){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Productopropio.findAllOrder");
        return q.getResultList();
    }
    
    public List<Productocomponente> productos_por_componente(Componente componente){
        EntityManager em = getEntityManager();
        Query q;
        if(componente != null){
            q = em.createNamedQuery("Productocomponente.findByCodComponente").setParameter("codComponente", componente.getCodComponente());
            return q.getResultList();
        }
        return null;
    }    
}
