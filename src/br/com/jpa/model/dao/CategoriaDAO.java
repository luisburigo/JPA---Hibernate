package br.com.jpa.model.dao;

import br.com.jpa.connection.ConnectionFactory;
import br.com.jpa.model.bean.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    public Categoria save(Categoria categoria) {
        EntityManager manager = new ConnectionFactory().getConnection();

        try {
            manager.getTransaction().begin();

            if (categoria.getId() == null) {
                manager.persist(categoria);
                manager.getTransaction().commit();
            } else {
                manager.merge(categoria);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }

        return categoria;
    }

    public Categoria findById(Integer id) {
        EntityManager manager = new ConnectionFactory().getConnection();
        Categoria categoria = null;

        try {
            categoria = manager.find(Categoria.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            manager.close();
        }

        return categoria;
    }

    public List<Categoria> findAll() {
        EntityManager manager = new ConnectionFactory().getConnection();
        List<Categoria> categorias = null;

        try {
            categorias = manager.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            manager.close();
        }

        return categorias;
    }

    public Categoria remove(Integer id) {
        EntityManager manager = new ConnectionFactory().getConnection();
        Categoria categoria = null;

        try {
            categoria = manager.find(Categoria.class, id);

            manager.getTransaction().begin();
            manager.remove(categoria);
            manager.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }

        return categoria;
    }

}
