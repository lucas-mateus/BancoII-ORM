package br.edu.unijuazeiro.appmusic.model.podcast;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.edu.unijuazeiro.appmusic.model.usuario.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Podcast {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPodcast;
    @Column(nullable = false)
    private String owner;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @JoinTable(name = "consumer_follow",
        joinColumns = {@JoinColumn(name="podcast_id", referencedColumnName = "idPodcast")},
        inverseJoinColumns = {@JoinColumn(name="consumer_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Consumer> consumers;

}
