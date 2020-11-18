package br.edu.unijuazeiro.appmusic.service;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.edu.unijuazeiro.appmusic.dao.ConsumerDAO;
import br.edu.unijuazeiro.appmusic.model.usuario.Consumer;

public class ConsumerService {
    ConsumerDAO cDAO = new ConsumerDAO();

    //function to validate email
    public boolean isValidEmailAddress(String email){
        boolean isEmailValid = false;
        
        if(email!=null && email.length()>0){
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            
            if(matcher.matches()){
                isEmailValid = true;
            }
        }
        
        return isEmailValid;
    }

    public void save(Consumer consumer){
       boolean isValid = isValidEmailAddress(consumer.getEmail());
       if(isValid && consumer.getName().length()>0){
           if(consumer.getPassword()!=null && consumer.getPassword().length() > 7 ){
                String pswCipher = BCrypt.withDefaults().hashToString(11, consumer.getPassword().toCharArray());
                consumer.setPassword(pswCipher);
                cDAO.save(consumer);
           }else{
               throw new RuntimeException("Senha deve conter 8 ou mais caracteres!");
           }
       }else{
           throw new RuntimeException("Email inválido/Campo Nome não pode ser vazio");
       }
    }

    public void update(Consumer consumer){
        cDAO.update(consumer);
    }

    public void remove(Integer consumerId){
        Consumer consumer = cDAO.findById(consumerId);
        if(consumer != null){
           Scanner confirm = new Scanner(System.in);
           System.out.println("Você quer mesmo remover usuario?\n"+
            "1 - sim | 2 - não");
            int n = confirm.nextInt();

            switch(n){
                case 1:
                    cDAO.remove(consumerId);
                    confirm.close();
                    break;
                case 2:
                    System.out.println("Ok!");
                    confirm.close();
                    break;
            }
        }else{
            throw new RuntimeException("Usuário inválido.");
        }

    }

    public Consumer findById(Integer consumerId){
        return cDAO.findById(consumerId);
    }

    public List<Consumer> findByName(String name){
        return cDAO.findByName(name);
    }
}
