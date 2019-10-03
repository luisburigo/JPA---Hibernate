package br.com.jpa.testes;

import br.com.jpa.model.bean.Produto;
import br.com.jpa.model.dao.CategoriaDAO;
import br.com.jpa.model.dao.ProdutoDAO;

import java.util.List;

public class ProdutoTest {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.findAll();

        /*produto.setCategoria(new CategoriaDAO().findById(1));
        produto.setDescricao("Corona");
        produto.setValor(3.25);
        produto.setQuantidade(10);

        dao.save(produto);*/

        for (Produto produto : produtos) {
            System.out.println("Produto ----");
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Categoria: " + produto.getCategoria().getDescricao());
        }
    }

}
