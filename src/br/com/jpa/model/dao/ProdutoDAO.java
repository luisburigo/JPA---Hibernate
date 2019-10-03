package br.com.jpa.model.dao;

import br.com.jpa.connection.ConnectionFactory;
import br.com.jpa.model.bean.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    public Produto save(Produto produto) {
        EntityManager manager = new ConnectionFactory().getConnection();

        try {
            manager.getTransaction().begin();
            manager.persist(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }

        return produto;
    }

}
