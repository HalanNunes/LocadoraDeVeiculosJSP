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

import br.com.simpledev.spring.dao.CategoriaDao;
import br.com.simpledev.spring.model.Categoria;
import org.springframework.beans.factory.annotation.Qualifier;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaDao dao;

    @Autowired
    public CategoriaController(CategoriaDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/lista", method = GET)
    public List<Categoria> lista() {
        return dao.lista();
    }

    @RequestMapping(value = "/novo", method = GET)
    public ModelAndView novo() {
        return new ModelAndView("categoria/novo", "categoria", new Categoria());
    }

    @RequestMapping(value = "/novo", method = POST)
    public String novo(final Categoria categoria) {
        dao.adiciona(categoria);
        return "redirect:lista";
    }

    @RequestMapping(value = "/editar/{id}", method = GET)
    public ModelAndView editar(@PathVariable Long id) {
        Categoria categoria = dao.busca(id);
        return new ModelAndView("categoria/editar", "categoria", categoria);
    }

    @RequestMapping(value = "/editar", method = PUT)
    public String editar(final Categoria categoria) {
        dao.atualiza(categoria);
        return "redirect:lista";
    }
}
