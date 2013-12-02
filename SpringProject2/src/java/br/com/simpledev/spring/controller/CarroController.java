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

import br.com.simpledev.spring.dao.CarroDao;
import br.com.simpledev.spring.dao.CategoriaDao;
import br.com.simpledev.spring.dao.jdbc.JdbcCategoriaDao;
import br.com.simpledev.spring.model.Carro;
import br.com.simpledev.spring.model.Categoria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/carro")
public class CarroController {

    private final CarroDao dao;
    private final CategoriaDao categoriaDao = new JdbcCategoriaDao();
    private Map<String, Categoria> catCache;

    @Autowired
    public CarroController(final CarroDao dao) {
        this.dao = dao;

    }

    @InitBinder
    protected void iniBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Set.class, "categorias", new CustomCollectionEditor(Set.class) {
            protected Object convertElement(Object element) {
                if (element instanceof Categoria) {
                    System.out.println("Convertido!!");
                    return element;
                }
                if (element instanceof String) {
                    //Categoria cat = new Categoria(1, "Cat4", "", 5555);
                    Categoria cat = categoriaDao.lista().get((int) element);
                    System.out.println("Convertido String para Categoria!!" + cat);
                    return cat;
                }
                return null;
            }
        });
    }

    // @RequestMapping(method = RequestMethod.GET)
    public void defineCategoriaModel(ModelMap model) {
        List<Categoria> categorias = categoriaDao.lista();
        catCache = new HashMap<String, Categoria>();
        for (Categoria cat : categorias) {
            catCache.put(cat.getId().toString(), cat);
        }
        model.addAttribute("categoriasParaCarro", catCache);
        model.addAttribute("message", "Spring 3 MVC Hello World");
    }
    
    private List<?> populateCategorias(){
        CategoriaDao categoria = new JdbcCategoriaDao();
        List<Categoria> categorias = categoria.lista();
        return categorias;
    }
    
    @RequestMapping(value = "/lista", method = GET)
    public List<Carro> lista() {
        return dao.lista();
    }

    @ModelAttribute("categorias")
    public Collection<Categoria> getCategorias() {
        List<Categoria> cats = this.categoriaDao.lista();
        System.out.println("Catigoria" + cats.size() + ";");
        return cats;
    }

    @RequestMapping(value = "/novo", method = GET)
    public ModelAndView novo() {
        ModelAndView modelAndView = new ModelAndView("carro/novo", "carro", new Carro());
        ModelMap model = modelAndView.getModelMap();
        model.addAttribute("getListaCategorias", populateCategorias());
        return modelAndView;
    }

    @RequestMapping(value = "/novo", method = POST)
    public String novo(final Carro carro) {
        dao.adiciona(carro);
        return "redirect:lista";
    }

    @RequestMapping(value = "/editar/{id}", method = GET)
    public ModelAndView editar(@PathVariable Long id) {
        Carro carro = dao.busca(id);
        // carro.setListaCategorias(categoriaDao.lista());
        return new ModelAndView("carro/editar", "carro", carro);
    }

    @RequestMapping(value = "/editar", method = PUT)
    public String editar(final Carro carro) {
        dao.atualiza(carro);
        return "redirect:lista";
    }
}
