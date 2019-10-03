package br.com.jpa.testes;

import br.com.jpa.model.bean.Produto;
import br.com.jpa.model.dao.CategoriaDAO;
import br.com.jpa.model.dao.ProdutoDAO;

public class ProdutoTest {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();

        produto.setDescricao("Budweiser");
        produto.setQuantidade(10);
        produto.setValor(3.29);
        produto.setCategoria(new CategoriaDAO().findById(1));

        dao.save(produto);
    }

}
