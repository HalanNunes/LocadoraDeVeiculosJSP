package br.com.simpledev.spring.model;

import br.com.simpledev.spring.dao.jdbc.JdbcCategoriaDao;
import java.util.ArrayList;
import java.util.List;

public class Carro {

    private Integer id;
    private String nome;
    private Integer ano;
    private String categoria;

    public Carro() {
    }

    public Carro(final Integer id, final String nome, final Integer ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
