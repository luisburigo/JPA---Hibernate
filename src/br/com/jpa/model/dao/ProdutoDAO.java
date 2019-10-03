package br.com.jpa.model.dao;

import br.com.jpa.model.bean.Produto;

public class ProdutoDAO extends DAO<Produto, Integer> {

    public ProdutoDAO() {
        super(Produto.class);
    }
}
