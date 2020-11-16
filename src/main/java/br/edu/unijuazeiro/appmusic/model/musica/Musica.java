package br.edu.unijuazeiro.appmusic.model.musica;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Musica {
    
    @Id
    private Integer id;
    private String nameMusic;
    private String time; 
}
