package br.edu.unijuazeiro.appmusic.dao;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.appmusic.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.appmusic.model.album.Album;

public class AlbumDAO {
    
    public void save(Album album){
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(album);
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

    public void update(Album album){
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(album);
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

    public void remove(String idAlbum){
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            em.getTransaction().begin();
            Album alb = em.find(Album.class, idAlbum);
            em.remove(alb);
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

    public Album findByName(String name){
        EntityManager em = ConnectionFactory.getEntityManager();
        Album alb = em.createQuery("select a from Album where lower(a.name) like lower(:name)", Album.class)
        .setParameter("name", name)
        .getSingleResult();

        if(em.isOpen()){
            em.close();
        }
        return alb;
    }

    public Album findByNameAndReleaseYear(String name, String year){
        EntityManager em = ConnectionFactory.getEntityManager();

        Album alb = em.createQuery("select a from Album a where lower(a.nameAlbum) like lower(:name)"+
        " and a.releaseYear like :year", Album.class)
        .setParameter("name", "%"+name+"%")
        .setParameter("year", year)
        .getSingleResult();
        
        if(em.isOpen()){
            em.close();
        }
        return alb;
    }
}
