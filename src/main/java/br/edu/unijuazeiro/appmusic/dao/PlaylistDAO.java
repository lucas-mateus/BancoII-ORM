package br.edu.unijuazeiro.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.appmusic.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.appmusic.model.playlist.Playlist;

public class PlaylistDAO {
    
    public void save(Playlist playlist){
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(playlist);
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

    public void update(Playlist playlist){
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(playlist);
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

    public void remove(Integer idPlaylist){
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Playlist pl = em.find(Playlist.class, idPlaylist);
            em.remove(pl);
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

    public List<Playlist> search(String name){
        EntityManager em = ConnectionFactory.getEntityManager();

        List<Playlist> pls = em.createQuery("select p from Playlist p join p.music m where lower(p.namePlaylist) like lower(:name)"+
        "or lower(m.nameMusic) like lower(:name)", Playlist.class).setParameter("name", "%"+ name +"%").getResultList();

        if(em.isOpen()){
            em.close();
        }

        return pls;
    }
}
