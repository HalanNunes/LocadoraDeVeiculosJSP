package br.com.simpledev.spring.dao;

import java.util.List;

import br.com.simpledev.spring.model.Categoria;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
public interface CategoriaDao {

    List<Categoria> lista();

    void adiciona(Categoria categoria);

    Categoria busca(Long id);

    void atualiza(Categoria categoria);
}
