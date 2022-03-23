/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.AutorPremio;
import Entidades.Autores;
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
public class PremiosFacade extends AbstractFacade<Premios> {

    @PersistenceContext(unitName = "Biblioteca2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PremiosFacade() {
        super(Premios.class);
    }
    
     public List<Premios> premios_orden(){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Premios.findAll");
        return q.getResultList();
    }
    
    public List<Premios> premios_autor(){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Premios.findByTipo").setParameter("tipo", 'A');
        return q.getResultList();
    }

    public List<Premios> premios_libro(){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Premios.findByTipo").setParameter("tipo", 'L');
        return q.getResultList();
    }    
    
    public List<AutorPremio> premio_por_autor (Autores autor){
        EntityManager em = getEntityManager();
        Query q;
        if(autor != null){
            q = em.createNamedQuery("AutorPremio.findByCodAutor").setParameter("codAutor", autor.getCodAutor());
            return q.getResultList();
        }
        return null;
    } 
}
