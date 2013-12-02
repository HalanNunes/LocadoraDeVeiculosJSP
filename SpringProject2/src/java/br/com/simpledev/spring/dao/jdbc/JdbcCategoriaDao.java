package br.com.simpledev.spring.dao.jdbc;

import br.com.simpledev.spring.dao.CategoriaDao;
import br.com.simpledev.spring.model.Categoria;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcCategoriaDao implements CategoriaDao {

    private final List<Categoria> database = new ArrayList<Categoria>();

    public JdbcCategoriaDao() {
        database.add(new Categoria(1, "Popular", "Carro simplicimo", 69.00));
        database.add(new Categoria(2, "Luxo", "Carro riquisimo", 100.00));
    }

    public List<Categoria> lista() {
        return database;
    }

    public void adiciona(final Categoria categoria) {
        categoria.setId(database.size() + 1);
        database.add(categoria);
    }

    public Categoria busca(Long id) {
        return database.get(id.intValue() - 1);
    }

    public void atualiza(Categoria categoria) {
    }
}
