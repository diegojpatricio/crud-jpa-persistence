package repositories;

import model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * @author: Diego Patrício
 * */

public class ProdutoDAO {

    public EntityManager getEM(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("automacaocomercial");
        return entityManagerFactory.createEntityManager();
    }





    public Produto salvarProduto(Produto produto){
       EntityManager em = getEM();
       try {
           em.getTransaction().begin();
           if (produto.getId() == null) {
               em.persist(produto);
           } else {
               produto = em.merge(produto);
           }
           em.getTransaction().commit();
       } catch (Exception e){
           em.getTransaction().rollback();
       }
       finally {
           em.close();
       }
       return produto;
    }

    public Produto deletarProduto(Integer id){
        EntityManager em = getEM();
        Produto produto = em.find(Produto.class, id);
        try {
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return produto;
    }

    public  Produto consultarProduto(Integer id){
        EntityManager em = getEM();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
        } finally {
            em.close();
        }
        return produto;
    }

}
