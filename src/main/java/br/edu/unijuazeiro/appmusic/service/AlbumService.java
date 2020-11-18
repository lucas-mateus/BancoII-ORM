package br.edu.unijuazeiro.appmusic.service;

import java.util.List;

import br.edu.unijuazeiro.appmusic.dao.AlbumDAO;
import br.edu.unijuazeiro.appmusic.model.album.Album;

public class AlbumService {
    AlbumDAO albDAO = new AlbumDAO();

    public void save(Album album){
        if(album.getArtist() == null){
            System.out.println("Album precisa ter um artista relacionado!");
            
        }
        albDAO.save(album);
    }

    public void update(Album album){
        albDAO.update(album);
    }

    public void remove(String albumId){
        albDAO.remove(albumId);
    }

    public Album findByName(String name){
        return albDAO.findByName(name);
    }

    public Album findByNameAndReleaseYear(String name, String year){
        return albDAO.findByNameAndReleaseYear(name, year);
    }

    public List<Album> findByNameOrArtist(String search){
        return albDAO.findByNameOrArtist(search);
    }

}
