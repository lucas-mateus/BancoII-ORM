package br.edu.unijuazeiro.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.appmusic.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.appmusic.model.usuario.Consumer;

public class ConsumerDAO {
    
    public void save(Consumer consumer){
        EntityManager em = ConnectionFactory.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(consumer);
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    public void update(Consumer consumer){
        EntityManager em = ConnectionFactory.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(consumer);
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    public void remove(Integer consumerId){
        EntityManager em = ConnectionFactory.getEntityManager();

        try{
            em.getTransaction().begin();
            Consumer consumer = em.find(Consumer.class, consumerId);
            em.remove(consumer);
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    public Consumer findById(Integer consumerId){
        EntityManager em = ConnectionFactory.getEntityManager();
        Consumer consumer = em.find(Consumer.class, consumerId);
        
        if(em.isOpen()){
            em.close();
        }
        return consumer;
    }

    public List<Consumer> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Consumer> users = em.createQuery("select c from User c where lower(c.name) like lower(:name)", Consumer.class)
                .setParameter("name", "%" + name + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return users;
    }
}
