package br.edu.unijuazeiro.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.appmusic.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.appmusic.model.usuario.User;

public class UserDAO {
    
    public void saveUser(User user){
        EntityManager em = ConnectionFactory.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(user);
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

    public void updateuser(User user){
        EntityManager em = ConnectionFactory.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(user);
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

    public void removeUser(Integer userId){
        EntityManager em = ConnectionFactory.getEntityManager();

        try{
            em.getTransaction().begin();
            User user = em.find(User.class, userId);
            em.remove(user);
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

    public User findById(Integer userId){
        EntityManager em = ConnectionFactory.getEntityManager();
        User user = em.find(User.class, userId);
        
        if(em.isOpen()){
            em.close();
        }
        return user;
    }

    public List<User> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<User> users = em.createQuery("select u from User u where lower(c.name) like lower(:name)", User.class)
                .setParameter("name", "%" + name + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return users;
    }
}
