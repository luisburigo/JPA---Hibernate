package br.com.jpa.dao;

import br.com.jpa.model.bean.Categoria;

public class CategoriaDAO extends DAO<Categoria, Integer>  {

    public CategoriaDAO() {
        super(Categoria.class);
    }

}
