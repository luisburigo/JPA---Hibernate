import br.com.jpa.dao.ProdutoDAO;
import br.com.jpa.model.bean.Categoria;
import br.com.jpa.model.bean.Produto;
import br.com.jpa.repositories.ProdutoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProdutoRepositoryTest {

    private static ProdutoRepository repository;

    @Test
    public void buscarProdutosPelaCategoria() {
        Categoria categoria = new Categoria();
        categoria.setId(1);

        List<Produto> produtos = repository.buscaProdutosPelaCategoria(categoria);

        Assert.assertEquals(produtos.size(), 1);
        System.out.println("Quantidade de produtos: " + produtos.size());

        Assert.assertEquals(produtos.get(0).getCategoria().getDescricao(), "Informatica");
        System.out.println("Categoria do produto: " + produtos.get(0).getCategoria().getDescricao());
    }

    @Before
    public void iniciarDAO() {
        repository = new ProdutoRepository();
    }

}
