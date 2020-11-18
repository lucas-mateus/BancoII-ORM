package br.edu.unijuazeiro.appmusic.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consumer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_user")
    @SequenceGenerator(name = "gen_user", initialValue = 1, allocationSize = 10,sequenceName = "gen_user" )
    private Integer id;
    private String name;
    
    @Column(unique=true)
    private String email;
    private String password;
    private String sex; 

   
}
