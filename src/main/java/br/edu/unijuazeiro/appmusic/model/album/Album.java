package br.edu.unijuazeiro.appmusic.model.album;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.edu.unijuazeiro.appmusic.model.artist.Artist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_album")
    @SequenceGenerator(sequenceName = "seq_album", allocationSize = 1, name = "gen_album", initialValue = 1)
    private Integer id;
    @Column(nullable = false)
    private String nameAlbum;
    @Column(nullable = false)
    private String releaseYear;

    @ManyToOne
    @JoinColumn
    private Artist artist;

}
