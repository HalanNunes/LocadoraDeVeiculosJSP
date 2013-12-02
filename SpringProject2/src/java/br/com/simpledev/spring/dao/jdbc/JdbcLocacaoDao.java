package br.com.simpledev.spring.dao.jdbc;

import br.com.simpledev.spring.dao.LocacaoDao;
import br.com.simpledev.spring.model.Locacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcLocacaoDao implements LocacaoDao {

    private final List<Locacao> database = new ArrayList<Locacao>();

    public JdbcLocacaoDao() {
        database.add(new Locacao(1, "Halan", "Fusca", 20));
        database.add(new Locacao(2, "Thiago", "BMW", 20));
    }

    public List<Locacao> lista() {
        return database;
    }
    
    public List<Locacao> listaDevolvidos(){
        List<Locacao> locacoesDevolvidas = new ArrayList<Locacao>();
        for(Locacao locs : database){
            if(locs.getStatusLocacao() == 2){//Se a locação estiver Devolvida, adiciona no arrayList
                locacoesDevolvidas.add(locs);
            }
        }
        return locacoesDevolvidas;
    }
    
    public List<Locacao> listaLocados(){
        List<Locacao> locacoesLocadas = new ArrayList<Locacao>();
        for(Locacao locs : database){
            if(locs.getStatusLocacao() == 1){//Se a locação estiver Locada, adiciona no arrayList
                locacoesLocadas.add(locs);
            }
        }
        return locacoesLocadas;
    }
    
    public void adiciona(final Locacao locacao) {
        locacao.setId(database.size() + 1);
        database.add(locacao);
    }

    public Locacao busca(Long id) {
        return database.get(id.intValue() - 1);
    }
    
    public void devolver(Locacao locacao){
        locacao.setStatusLocacao(2);
        locacao.setDataLocacao(getActualDateTime());
    }
    
    public void atualiza(Locacao locacao) {
    }
    
    //Traz a data e hora atual da devolução.
    private String getActualDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
