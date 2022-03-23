/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Cliente;
import Entidades.Pedidocliente;
import java.util.Date;
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
public class PedidoclienteFacade extends AbstractFacade<Pedidocliente> {

    @PersistenceContext(unitName = "ExamenEduardoGuerreroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoclienteFacade() {
        super(Pedidocliente.class);
    }
    
    public List<Pedidocliente> pedidosclientes_por_cliente(Cliente cliente){
        EntityManager em = getEntityManager();
        Query q;
        if(cliente != null){
            q = em.createNamedQuery("Pedidocliente.findByCodCliente").setParameter("codCliente", cliente);
            return q.getResultList();
        }
        return null;
    } 
    
    public List<Pedidocliente> pedidos_por_fechas(Date fecha1, Date fecha2){
        EntityManager em = getEntityManager();
        Query q;
        
        if(fecha1 != null && fecha2 != null){
            System.out.println("llega");
            q = em.createNamedQuery("Pedidocliente.findByFechas").setParameter("fecha1", fecha1).setParameter("fecha2", fecha2);
            return q.getResultList();
         }
        return null;
    } 
    
}
