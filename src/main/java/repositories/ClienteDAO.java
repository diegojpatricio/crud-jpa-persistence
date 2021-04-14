package repositories;

import model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * @author: Diego Patrício
 * */

public class ClienteDAO {

    public EntityManager getEM(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("automacaocomercial");
        return entityManagerFactory.createEntityManager();
    }





    public Cliente salvarCliente(Cliente cliente){
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (cliente.getId() == null) {
                em.persist(cliente);
            } else {
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return cliente;
    }

    public Cliente deletarCliente(Integer id){
        EntityManager em = getEM();
        Cliente cliente = em.find(Cliente.class, id);
        try {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return cliente;
    }

    public Cliente consultarCliente(Integer id){
        EntityManager em = getEM();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
        } finally {
            em.close();
        }
        return cliente;
    }

}
