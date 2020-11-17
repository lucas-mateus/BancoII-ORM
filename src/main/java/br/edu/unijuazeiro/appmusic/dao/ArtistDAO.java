package br.edu.unijuazeiro.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.appmusic.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.appmusic.model.artist.Artist;

public class ArtistDAO {
    
    public void save(Artist artist){
        EntityManager em = ConnectionFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(artist);
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
    
    public void update(Artist artist){
        EntityManager em = ConnectionFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(artist);
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

    public void remove(Integer artistId){
        EntityManager em = ConnectionFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            Artist artist = em.find(Artist.class, artistId);
            em.remove(artist);
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

    
    public List<Artist> findByName(String name){
        EntityManager em = ConnectionFactory.getEntityManager();

        List<Artist> artists = em.createQuery("select a from Artist a where lower(a.name) like lower(:name)", Artist.class)
        .setParameter("name","%"+name+"%").getResultList();

        if(em.isOpen()){
            em.close();
        }
        return artists;
    }

}
