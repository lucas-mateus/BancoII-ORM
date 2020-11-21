package br.edu.unijuazeiro.appmusic.dao;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.appmusic.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.appmusic.model.podcast.Podcast;

public class PodcastDAO {
    
    public void save(Podcast podcast){
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(podcast);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    public void update(Podcast podcast){
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(podcast);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    public void remove(Integer podcastId){
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Podcast pd = em.find(Podcast.class, podcastId);
            em.remove(pd);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally{
            if(em.isOpen()){
                em.close();
            }
        }
    }

    public Podcast findByName(String name){
        EntityManager em = ConnectionFactory.getEntityManager();
        
        Podcast pd = em.createQuery("select p from Podcast where p lower(p.name) like lower(:name)",Podcast.class)
            .setParameter("name", "%"+name+"%").getSingleResult();

        if(em.isOpen()){
            em.close();
        }
        
        return pd;
    }
}
