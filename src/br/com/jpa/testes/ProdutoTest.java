package br.com.jpa.testes;

import br.com.jpa.model.bean.Produto;
import br.com.jpa.model.dao.CategoriaDAO;
import br.com.jpa.model.dao.ProdutoDAO;

public class ProdutoTest {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.findById(1);

        System.out.println("Produto ----");
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Categoria: " + produto.getCategoria().getDescricao());
    }

}
