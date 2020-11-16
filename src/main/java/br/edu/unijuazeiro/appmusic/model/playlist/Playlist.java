package br.edu.unijuazeiro.appmusic.model.playlist;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Playlist {
    
    @Id
    private Integer id;
    private String namPlaylist;
}
