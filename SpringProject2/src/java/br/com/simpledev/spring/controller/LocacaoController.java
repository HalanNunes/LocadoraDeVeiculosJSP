package br.com.simpledev.spring.controller;

import br.com.simpledev.spring.dao.CarroDao;
import br.com.simpledev.spring.dao.ClienteDao;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.simpledev.spring.dao.LocacaoDao;
import br.com.simpledev.spring.dao.jdbc.JdbcCarroDao;
import br.com.simpledev.spring.dao.jdbc.JdbcClienteDao;
import br.com.simpledev.spring.model.Carro;
import br.com.simpledev.spring.model.Cliente;
import br.com.simpledev.spring.model.Locacao;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/locacao")
public class LocacaoController {

    private final LocacaoDao dao;

    @Autowired
    public LocacaoController(LocacaoDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/lista", method = GET)
    public List<Locacao> lista() {
        return dao.lista();
    }
    
    @RequestMapping(value = "/listaDevolvidos", method = GET)
    public List<Locacao> listaDevolvidos() {
        return dao.listaDevolvidos();
    }
    
    @RequestMapping(value = "/listaLocados", method = GET)
    public List<Locacao> listaLocados() {
        return dao.listaLocados();
    }
    
    private List<?> popularCliente(){
        ClienteDao clienteDao = new JdbcClienteDao();
        List<Cliente> clientes = clienteDao.lista();
        return clientes;
    }
    
    private List<?> popularCarro(){
        CarroDao carroDao = new JdbcCarroDao();
        List<Carro> carros = carroDao.lista();
        return carros;
    }
    
    @RequestMapping(value = "/novo", method = GET)
    public ModelAndView novo() {
        ModelAndView modelAndView =  new ModelAndView("locacao/novo", "locacao", new Locacao());
        ModelMap model = modelAndView.getModelMap();
        model.addAttribute("getListaClientes", popularCliente());
        model.addAttribute("getListaCarros", popularCarro());
        return modelAndView;
    }
    
    @RequestMapping(value = "/novo", method = POST)
    public String novo(final Locacao locacao) {
        dao.adiciona(locacao);
        return "redirect:lista";
    }

    @RequestMapping(value = "/editar/{id}", method = GET)
    public ModelAndView editar(@PathVariable Long id) {
        Locacao locacao = dao.busca(id);
        ModelAndView modelAndView =  new ModelAndView("locacao/novo", "locacao", locacao);
        ModelMap model = modelAndView.getModelMap();
        model.addAttribute("getListaClientes", popularCliente());
        model.addAttribute("getListaCarros", popularCarro());
        return modelAndView;
    }

    @RequestMapping(value = "/editar", method = PUT)
    public String editar(final Locacao locacao) {
        dao.atualiza(locacao);
        return "redirect:lista";
    }
    
    @RequestMapping(value = "/devolver/{id}", method = GET)
    public String devolver(@PathVariable Long id) {
        Locacao locacao = dao.busca(id);
        dao.devolver(locacao);
        return "../locacao/listaDevolvidos";
    }
}
