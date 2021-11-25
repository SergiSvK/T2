package tech.sergisvk.ecotech.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.sergisvk.ecotech.DominioSesion;
import tech.sergisvk.ecotech.utilidades.IsNavidad;
import tech.sergisvk.ecotech.utilidades.Util;
import tech.sergisvk.ecotech.servicios.CategoriaService;
import tech.sergisvk.ecotech.servicios.ProductoService;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    public String index(Model model){

        Calendar calendario = GregorianCalendar.getInstance();
        int ihora= calendario.get(Calendar.HOUR_OF_DAY);
        IsNavidad isNavidad = new IsNavidad(calendario);

        /*
        if (isNavidad.isNavidad()) {
            model.addAttribute("css","navidad");
        } else if (ihora>=22 || ihora <=7) {
            model.addAttribute("css","oscuro");
        }*/

        model.addAttribute("nameShop", Util.host());
        model.addAttribute("year", Util.yearString());
        model.addAttribute("domain", Util.host());
        model.addAttribute("phone", Util.phone);
        model.addAttribute("productos",producto.findAll());
        return "index";
    }

    /**
     * Login de usuario
     * @param model
     * @return /login
     */
    @GetMapping({"/login"})
    public String login(Model model) {
        model.addAttribute("nameShop", Util.host());
        model.addAttribute("year", Util.yearString());
        model.addAttribute("domain", Util.host());
        model.addAttribute("phone", Util.phone);
        return "windows/login";
    }

    /**
     * Login de usuario
     * @param model
     * @return /login
     */
    @GetMapping({"/productos"})
    public String productos(Model model) {
        model.addAttribute("nameShop", Util.host());
        model.addAttribute("year", Util.yearString());
        model.addAttribute("domain", Util.host());
        model.addAttribute("phone", Util.phone);
        model.addAttribute("productos",producto.findAll());
        return "windows/productos";
    }

    @GetMapping({"/windows/catalogo"})
    public String catalogo(Model model) {
        model.addAttribute("productos",producto.findAll());
        return "windows/catalogo";
    }

}
