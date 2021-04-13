package repositories;

import model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


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

    public void deletarCliente(Cliente cliente){
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }

    public Cliente buscarCliente(Integer id){
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return cliente;
    }
}
