package br.edu.unijuazeiro.appmusic.model.artista;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Artista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_artista")
    @SequenceGenerator(sequenceName = "seq_artista", allocationSize = 1, name = "gen_artista", initialValue = 1)
    private Integer id;
    private String nameArtist;
    private Long biography;
    private Long photo;

}
