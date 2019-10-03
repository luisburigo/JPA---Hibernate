import br.com.jpa.dao.ProdutoDAO;
import br.com.jpa.model.bean.Categoria;
import br.com.jpa.model.bean.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {

    private static ProdutoDAO dao;

    @Test
    public void criarProdutoComCategoria() {
        Categoria categoria = new Categoria();
        categoria.setId(1);

        Produto produto = new Produto();
        produto.setCategoria(categoria);
        produto.setDescricao("Arroz");
        produto.setQuantidade(10);
        produto.setValor(10.5);

        dao.save(produto);

        Assert.assertEquals(produto.getCategoria().getDescricao(), categoria.getDescricao());
    }

    @Before
    public void iniciarDAO() {
        dao = new ProdutoDAO();
    }

}
