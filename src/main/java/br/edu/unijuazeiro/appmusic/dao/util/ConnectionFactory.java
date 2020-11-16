package br.edu.unijuazeiro.appmusic.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ConnectionFactory {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("appmusic-unijuazeiro") ;

    private ConnectionFactory(){}

    public static EntityManagerFactory getEmf(){
        return emf;
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }


}
