package br.com.jpa.repositories;

import br.com.jpa.connection.ConnectionFactory;
import br.com.jpa.dao.CategoriaDAO;
import br.com.jpa.model.bean.Categoria;
import br.com.jpa.model.bean.Produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProdutoRepository {

    @PersistenceContext
    private static EntityManager manager = new ConnectionFactory().getConnection();

    public List<Produto> buscaProdutosPelaCategoria(Categoria categoria) {
        StringBuilder builder = new StringBuilder();

        List<Produto> produtos = null;
        categoria = new CategoriaDAO().findById(categoria.getId());

        if (categoria != null) {
            builder.append("From ")
                    .append(Produto.class.getSimpleName())
                    .append(" Where categoria_id = ")
                    .append(categoria.getId());

            produtos = manager.createQuery(builder.toString(), Produto.class).getResultList();
        }

        return produtos;
    }

}
