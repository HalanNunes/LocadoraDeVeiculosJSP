package br.com.simpledev.spring.dao;

import java.util.List;

import br.com.simpledev.spring.model.Cliente;

public interface ClienteDao {

    List<Cliente> lista();

    void adiciona(Cliente cliente);

    Cliente busca(Long id);

    void atualiza(Cliente cliente);
}
