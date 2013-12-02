package br.com.simpledev.spring.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.simpledev.spring.dao.ClienteDao;
import br.com.simpledev.spring.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteDao dao;

    @Autowired
    public ClienteController(final ClienteDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/lista", method = GET)
    public List<Cliente> lista() {
        return dao.lista();
    }

    @RequestMapping(value = "/novo", method = GET)
    public ModelAndView novo() {
        return new ModelAndView("cliente/novo", "cliente", new Cliente());
    }

    @RequestMapping(value = "/novo", method = POST)
    public String novo(final Cliente cliente) {
        dao.adiciona(cliente);
        return "redirect:lista";
    }

    @RequestMapping(value = "/editar/{id}", method = GET)
    public ModelAndView editar(@PathVariable Long id) {
        Cliente cliente = dao.busca(id);
        return new ModelAndView("cliente/editar", "cliente", cliente);
    }

    @RequestMapping(value = "/editar", method = PUT)
    public String editar(final Cliente cliente) {
        dao.atualiza(cliente);
        return "redirect:lista";
    }
}
