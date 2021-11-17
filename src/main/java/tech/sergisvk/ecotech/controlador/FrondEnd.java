package tech.sergisvk.ecotech.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.sergisvk.ecotech.DominioSesion;
import tech.sergisvk.ecotech.config.ConfigVariables;
import tech.sergisvk.ecotech.servicios.CategoriaService;

import java.net.MalformedURLException;

/**
 * Con la anotación @Controller se podrá detectar la clase Inicio cuando realice el escaneo de componentes.
 */
@Controller
public class FrondEnd {

    final private DominioSesion dominioSesion;

    final private CategoriaService catService;

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
        model.addAttribute("nameShop", ConfigVariables.hostURL().getHost());
        model.addAttribute("year", ConfigVariables.yearString());
        model.addAttribute("domain", ConfigVariables.hostURL().getHost());
        model.addAttribute("phone", ConfigVariables.phone);
        return "index";
    }

}
