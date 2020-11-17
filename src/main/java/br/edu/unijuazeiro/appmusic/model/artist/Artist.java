package br.edu.unijuazeiro.appmusic.model.artist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.edu.unijuazeiro.appmusic.model.album.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_artista")
    @SequenceGenerator(sequenceName = "seq_artista", allocationSize = 1, name = "gen_artista", initialValue = 1)
    private Integer id;
    private String nameArtist;
    private Long biography;
    
    @OneToMany
    @JoinColumn
    private Album album;

}
