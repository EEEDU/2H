/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Componente;
import Entidades.Lineapcliente;
import Entidades.Marca;
import Entidades.Pedidocliente;
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
public class ComponenteFacade extends AbstractFacade<Componente> {

    @PersistenceContext(unitName = "ExamenEduardoGuerreroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponenteFacade() {
        super(Componente.class);
    }
    
    public List<Componente> componentes_ordenados(){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Componente.findAllOrder");
        return q.getResultList();
    }
    
    public List<Componente> componentes_por_marca(Marca marca){
        EntityManager em = getEntityManager();
        Query q;
            q = em.createNamedQuery("Componente.findByCodMarca").setParameter("codMarca", marca);
            return q.getResultList();
    }    
    
    public List<Productocomponente> componentes_por_producto(Productopropio producto){
        EntityManager em = getEntityManager();
        Query q;
        if(producto != null){
            q = em.createNamedQuery("Productocomponente.findByCodProducto").setParameter("codProducto", producto.getCodProducto());
            return q.getResultList();
        }
        return null;
    }  
    public List<Lineapcliente> pedidos_por_producto(Productopropio producto){
        EntityManager em = getEntityManager();
        Query q;
        if(producto != null){
            q = em.createNamedQuery("Lineapcliente.findByProducto").setParameter("codProducto", producto);
            return q.getResultList();
        }
        return null;
    }
    
}
