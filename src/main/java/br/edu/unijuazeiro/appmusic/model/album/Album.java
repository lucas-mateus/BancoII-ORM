package br.edu.unijuazeiro.appmusic.model.album;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.edu.unijuazeiro.appmusic.model.music.Music;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Album {
    
    @Id
    private Integer id;
    private String nameAlbum;
    private String releaseDate;

    @OneToMany
    @JoinColumn
    private Music music;

}
