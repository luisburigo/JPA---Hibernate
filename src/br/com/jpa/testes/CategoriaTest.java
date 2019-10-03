package br.com.jpa.testes;

import br.com.jpa.model.bean.Categoria;
import br.com.jpa.model.dao.CategoriaDAO;

import java.util.List;

public class CategoriaTest {

    public static void main(String[] args){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = categoriaDAO.remove(3);


    }

}
