package br.edu.unijuazeiro.appmusic.model.music;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.edu.unijuazeiro.appmusic.model.album.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Music {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_music")
    @SequenceGenerator(name = "gen_music", sequenceName = "seq_music", initialValue = 1, allocationSize = 1)
    private Integer id;
    private String nameMusic;
    private String time; 

    @JoinColumn
    @ManyToOne
    private Album album;
}
