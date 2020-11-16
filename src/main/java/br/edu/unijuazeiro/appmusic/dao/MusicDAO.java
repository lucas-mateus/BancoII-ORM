package br.edu.unijuazeiro.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.appmusic.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.appmusic.model.music.Music;

public class MusicDAO {
    
    public void save(Music music){
        EntityManager em = ConnectionFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(music);
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

    public void update(Music music){
        EntityManager em = ConnectionFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(music);
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

    public void remove(Integer musicId){
        EntityManager em = ConnectionFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            Music music = em.find(Music.class, musicId);
            em.remove(music);
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


    public List<Music> findByName(String name){
        EntityManager em = ConnectionFactory.getEntityManager();

        List<Music> musics = em.createQuery("select m from Music m where lower(c.name) like lower(:name)", Music.class)
        .setParameter("name","%"+name+"%").getResultList();

        if(em.isOpen()){
            em.close();
        }
        return musics;
    }

    public List<Music> listAll(){
        EntityManager em = ConnectionFactory.getEntityManager();

        List<Music> allMusics = em.createQuery("select m from Music m", Music.class).getResultList();
        
        if(em.isOpen()){
            em.close();
        }

        return allMusics;
    }
}
