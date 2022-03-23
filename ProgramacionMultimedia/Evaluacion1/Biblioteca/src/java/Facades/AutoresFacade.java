/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.AutorPremio;
import Entidades.Autores;
import Entidades.Paises;
import Entidades.Premios;
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
public class AutoresFacade extends AbstractFacade<Autores> {

    @PersistenceContext(unitName = "Biblioteca2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoresFacade() {
        super(Autores.class);
    }
    
    public List<Autores> autores_orden(){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Autores.findAllOrder");
        return q.getResultList();
    }    
    
    public List<Autores> autores_pais(Paises pais){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Autores.findByPais").setParameter("elPais", pais);
        return q.getResultList();
    }
    
    public List<Autores> autores_premio(Premios premio){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("AutorPremio.findByCodPremio").setParameter("elPremio", premio.getCodPremio());
        return q.getResultList();
       
    }
        
   public List<AutorPremio> autores_por_premio(Premios premio){
        EntityManager em = getEntityManager();
        Query q;
        if(premio != null){
            q = em.createNamedQuery("AutorPremio.findByCodAutor").setParameter("codPremio", premio.getCodPremio());
            return q.getResultList();
        }
        return null;
    } 
   
   public List<Autores> autores_por_pais(Paises pais){
        EntityManager em = getEntityManager();
        Query q;
        if(pais != null){
            q = em.createNamedQuery("Autores.findByPais").setParameter("elPais", pais);
            return q.getResultList();
        }
        return null;
    } 
   
    public List<Premios> premios_por_pais(Paises pais){
        EntityManager em = getEntityManager();
        Query q;
        if(pais != null){
            q = em.createNamedQuery("Premios.findByPais").setParameter("elPais", pais.getCodPais());
            return q.getResultList();
        }
        return null;
    } 
    
    
}
