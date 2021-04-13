package repositories;

import model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * @author: Diego Patrício
 * */
public class ClienteRepository {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public ClienteRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("automacaocomercial");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void salvarCliente(Cliente cliente){
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }

    public Cliente atualizarCliente(Integer id){
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return cliente;


    }

    public Cliente buscarCliente(Integer id){
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return cliente;
    }

    public Cliente deletarCliente(Integer id){
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return cliente;

    }
}
