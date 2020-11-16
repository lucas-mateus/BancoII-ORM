package br.edu.unijuazeiro.appmusic.model.album;


import javax.persistence.Entity;
import javax.persistence.Id;

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

}
