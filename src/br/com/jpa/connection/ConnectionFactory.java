package br.com.jpa.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("meuPU");

    public EntityManager getConnection(){
        return factory.createEntityManager();
    }
}
