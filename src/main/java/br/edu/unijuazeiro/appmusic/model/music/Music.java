package br.edu.unijuazeiro.appmusic.model.music;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Music {
    
    @Id
    private Integer id;
    private String nameMusic;
    private String time; 
}
