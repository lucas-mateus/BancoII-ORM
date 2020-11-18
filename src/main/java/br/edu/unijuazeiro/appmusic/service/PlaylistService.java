package br.edu.unijuazeiro.appmusic.service;

import java.util.List;

import br.edu.unijuazeiro.appmusic.dao.PlaylistDAO;
import br.edu.unijuazeiro.appmusic.model.playlist.Playlist;

public class PlaylistService {
    PlaylistDAO pDAO = new PlaylistDAO();

    public void save(Playlist playlist){
        if(playlist.getNamePlaylist().length() < 0){
            throw new RuntimeException("Este campo não deve ser vazio!");
        }
        pDAO.save(playlist);
    }

    public void update(Playlist playlist){
        pDAO.update(playlist);
    }

    public void remove(Integer id){
        pDAO.remove(id);
    }

    public List<Playlist> findByPlaylistsOrMusic(String name){
        return pDAO.search(name);
    }
}
