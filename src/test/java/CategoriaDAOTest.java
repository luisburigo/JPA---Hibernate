import br.com.jpa.model.bean.Categoria;
import br.com.jpa.dao.CategoriaDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CategoriaDAOTest {

    private static CategoriaDAO dao;

    @Test
    public void criarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setDescricao("Informatica");

        Categoria novaCategoria = dao.save(categoria);

        Assert.assertEquals(categoria, novaCategoria);
    }

    @Before
    public void iniciarDAO() {
        dao = new CategoriaDAO();
    }

}
