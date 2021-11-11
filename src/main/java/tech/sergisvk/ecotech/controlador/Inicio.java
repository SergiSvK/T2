package tech.sergisvk.ecotech.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.sergisvk.ecotech.DominioSesion;
import tech.sergisvk.ecotech.config.Config;
import tech.sergisvk.ecotech.servicios.CategoriaService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Con la anotación @Controller se podrá detectar la clase Inicio cuando realice el escaneo de componentes.
 */
@Controller
public class Inicio {

    /*
     * Inspeccionará el contenedor y buscará un bean con el nombre exacto como propiedad para conectarlo automáticamente.
     * Por lo tanto, inyecta esa implementación específica al construir dominioSesion.
     */
    @Autowired
    private DominioSesion dominioSesion;

    @Autowired
    private CategoriaService catService;

    //Datos usados para obtener el año actual
    Date date = new Date();
    SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
    String year = getYearFormat.format(date);

    /**
     * Index
     * @param model brinda la capacidad de pasar una colección de valores y tratar estos valores como si estuvieran
     * dentro del mapa
     * @return index con las configuraciones pasadas
     */
    @GetMapping({"/","","/home","/inicio","/index"})
    public String index(Model model) {
        model.addAttribute("nameShop", Config.nameShop);
        model.addAttribute("year", year);
        model.addAttribute("domain", Config.domain);
        model.addAttribute("phone",Config.phone);
        //model.addAttribute("contenido","plantilla1");
        return "index";
    }

}
