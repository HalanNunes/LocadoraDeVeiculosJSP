package br.com.simpledev.spring.dao.jdbc;

import br.com.simpledev.spring.dao.ClienteDao;
import br.com.simpledev.spring.model.Cliente;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcClienteDao implements ClienteDao {

    private final List<Cliente> database = new ArrayList<Cliente>();

    public JdbcClienteDao() {
        database.add(new Cliente(1L, "Joao", "898898888"));
        database.add(new Cliente(2L, "Jose", "11111111"));
    }

    public List<Cliente> lista() {
        return database;
    }

    public void adiciona(final Cliente cliente) {
        cliente.setId((long) database.size() + 1);
        database.add(cliente);
    }

    public Cliente busca(Long id) {
        return database.get(id.intValue() - 1);
    }

    public void atualiza(Cliente cliente) {
    }
}
