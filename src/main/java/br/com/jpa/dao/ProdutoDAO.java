package br.com.jpa.dao;

import br.com.jpa.model.bean.Produto;

public class ProdutoDAO extends DAO<Produto, Integer> {

    public ProdutoDAO() {
        super(Produto.class);
    }
}
