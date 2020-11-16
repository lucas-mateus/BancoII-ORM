package br.edu.unijuazeiro.appmusic.model.usuario;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class User {
    
    @Id
    private Integer id;
    private String nameUser;
    private String email;
    private String password;
    private String sex;
}
