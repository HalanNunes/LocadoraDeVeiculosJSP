package br.com.simpledev.spring.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Halan
 */
public class Locacao {
    
    private Integer id;
    private String cliente;
    private String carro;
    private double valor;
    private int statusLocacao; //1 - Locado 2 - Devolvido
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Date date = new Date();
    private String dataLocacao;
    private String dataDevolucao;

    public Locacao() {
        this.statusLocacao = 1;
        //this.dataLocacao = dateFormat.format(date);
    }

    public Locacao(Integer id, String cliente, String carro, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.carro = carro;
        this.valor = valor;
        this.statusLocacao = 1;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public int getStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(int statusLocacao) {
        this.statusLocacao = statusLocacao;
    }
    
    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
