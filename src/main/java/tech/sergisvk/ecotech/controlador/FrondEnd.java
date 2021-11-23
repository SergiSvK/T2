package tech.sergisvk.ecotech.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.sergisvk.ecotech.DominioSesion;
import tech.sergisvk.ecotech.utilidades.Util;
import tech.sergisvk.ecotech.servicios.CategoriaService;
import tech.sergisvk.ecotech.servicios.ProductoService;

import java.net.MalformedURLException;

/**
 * Con la anotación @Controller se podrá detectar la clase Inicio cuando realice el escaneo de componentes.
 */
@Controller
public class FrondEnd {

    final private DominioSesion dominioSesion;

    final private CategoriaService catService;

    @Autowired
    private ProductoService producto;

    public FrondEnd(DominioSesion dominioSesion, CategoriaService catService) {
        this.dominioSesion = dominioSesion;
        this.catService = catService;
    }


    /**
     * Index
     * @param model brinda la capacidad de pasar una colección de valores y tratar estos valores como si estuvieran
     * dentro del mapa
     * @return index con las configuraciones pasadas
     */
    @GetMapping({"/","","/home","/inicio","/index"})
    public String index(Model model) throws MalformedURLException {
        model.addAttribute("nameShop", Util.hostURL().getHost());
        model.addAttribute("year", Util.yearString());
        model.addAttribute("domain", Util.hostURL().getHost());
        model.addAttribute("phone", Util.phone);
        model.addAttribute("productos",producto.findAll());
        return "index";
    }

    /**
     * Login de usuario
     * @param model
     * @return
     */
    @GetMapping({"/login"})
    public String admin(Model model) {
        model.addAttribute("nameShop", Util.hostURL().getHost());
        model.addAttribute("year", Util.yearString());
        model.addAttribute("domain", Util.hostURL().getHost());
        model.addAttribute("phone", Util.phone);
        return "windows/login";
    }

}
