package br.edu.unijuazeiro.appmusic.service;

import br.edu.unijuazeiro.appmusic.dao.PodcastDAO;
import br.edu.unijuazeiro.appmusic.model.podcast.Podcast;

public class PodcastService {
    PodcastDAO pDAO = new PodcastDAO();

    public void save(Podcast podcast){
        if(podcast.getName().length()<4){
            throw new RuntimeException("Nome deve conter pelo menos 4 caracteres.");
        }
        if(podcast.getDescription() == null){
            throw new RuntimeException("O podcast precisa ter uma breve descrição!");
        }

        pDAO.save(podcast);
    }

    public void update(Podcast podcast){
        pDAO.update(podcast);
    }


    public void remove(Integer podcastId){
        pDAO.remove(podcastId);
    }

    public Podcast findByName(String name){
        return pDAO.findByName(name);
    }


}
