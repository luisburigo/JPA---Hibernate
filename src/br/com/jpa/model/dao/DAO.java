package br.com.jpa.model.dao;

import br.com.jpa.connection.ConnectionFactory;
import br.com.jpa.model.bean.Model;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class DAO<T extends Model, I extends Serializable> {

    private EntityManager manager;
    private Class<T> classPersisted;

    DAO(Class<T> classPersisted) {
        this.manager = new ConnectionFactory().getConnection();
        this.classPersisted = classPersisted;
    }

    public T save(T obj) {
        manager.getTransaction().begin();

        if (obj.getId() == null) {
            manager.persist(obj);
        } else {
            manager.merge(obj);
        }

        manager.getTransaction().commit();
        return obj;
    }

    public T findById(I id) {
        return manager.find(classPersisted, id);
    }

    public T remove(I id) {
        T obj = manager.find(classPersisted, id);

        manager.getTransaction().begin();
        manager.remove(obj);
        manager.getTransaction().commit();

        return obj;
    }

    public List<T> findAll() {
        return manager.createQuery("from " + classPersisted.getName())
                .getResultList();
    }
}
