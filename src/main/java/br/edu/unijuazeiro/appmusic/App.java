package br.edu.unijuazeiro.appmusic;

import br.edu.unijuazeiro.appmusic.dao.ConsumerDAO;
import br.edu.unijuazeiro.appmusic.model.usuario.Consumer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Consumer consumer = new Consumer();
        consumer.setName("Lucas");
        consumer.setEmail("lucas@gmail.com");
        consumer.setPassword("123456");
        consumer.setSex("M");
        ConsumerDAO userDao = new ConsumerDAO();
        userDao.save(consumer);
    }
}
