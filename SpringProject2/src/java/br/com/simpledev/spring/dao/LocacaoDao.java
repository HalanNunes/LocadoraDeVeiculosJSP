package br.com.simpledev.spring.dao;

import br.com.simpledev.spring.model.Locacao;
import java.util.List;

/**
 *
 * @author Halan
 */
public interface LocacaoDao {
    
    List<Locacao> lista();

    void adiciona(Locacao locacao);

    Locacao busca(Long id);

    void atualiza(Locacao locacao);

    void devolver(Locacao locacao);
    
    List<Locacao> listaLocados();
    
    List<Locacao> listaDevolvidos();
}
