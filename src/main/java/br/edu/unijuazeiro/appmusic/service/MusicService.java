package br.edu.unijuazeiro.appmusic.service;

import java.util.List;

import br.edu.unijuazeiro.appmusic.dao.MusicDAO;
import br.edu.unijuazeiro.appmusic.model.music.Music;

public class MusicService {
    MusicDAO mDAO = new MusicDAO();

    public void save(Music music){
        if(music.getAlbum() == null && music.getNameMusic() == null){
            throw new RuntimeException("Cadastro de música inválido.");
        }
        mDAO.save(music);
    }

    public void update(Music music){
        mDAO.update(music);
    }

    public void remove(Integer musicId){
        mDAO.remove(musicId);
    }

    public List<Music> listAll(){
        return mDAO.listAll();
    }

    public List<Music> findByName(String name){
        return mDAO.findByName(name);
    }
}
