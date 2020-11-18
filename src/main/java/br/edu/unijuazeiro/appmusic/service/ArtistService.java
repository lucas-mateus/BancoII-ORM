package br.edu.unijuazeiro.appmusic.service;

import java.util.List;

import br.edu.unijuazeiro.appmusic.dao.ArtistDAO;
import br.edu.unijuazeiro.appmusic.model.artist.Artist;

public class ArtistService {
    
    private ArtistDAO artistDAO = new ArtistDAO();

    public void save(Artist artist){
        if(artist.getNameArtist() == null && artist.getBiography() == null){
            System.out.println("Campos do Artista não podem ser nulos!");
        }
        artistDAO.save(artist);
    }

    public void update(Integer artistId){
        artistDAO.remove(artistId);
    }
    
    public void remove(Integer artistId){
        artistDAO.remove(artistId);   
    }

    public List<Artist> findByName(String name){
       return artistDAO.findByName(name);
    }


    public List<Artist> listAll(){
        return artistDAO.listAll();
    }

}
