/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Autores;
import Entidades.Libros;
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
public class LibrosFacade extends AbstractFacade<Libros> {

    @PersistenceContext(unitName = "Biblioteca2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibrosFacade() {
        super(Libros.class);
    }
    
    public List<Libros> libros_por_autor(Autores autor){
        EntityManager em = getEntityManager();
        Query q;
        if(autor != null){
            q = em.createNamedQuery("Libros.findByAutor").setParameter("elAutor", autor);
            return q.getResultList();
        }
        return null;


    }    
    
    public List<Libros> libros_por_premio(Premios premio){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Libros.findByPremio").setParameter("elPremio", premio);
        return q.getResultList();
    }  
}
