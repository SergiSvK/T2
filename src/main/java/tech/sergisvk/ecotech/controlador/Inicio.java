package tech.sergisvk.ecotech.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.sergisvk.ecotech.DominioSesion;
import tech.sergisvk.ecotech.config.Config;
import tech.sergisvk.ecotech.servicios.CategoriaService;

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

    /**
     * Index
     * @param model
     * @return index con las configuraciones pasadas
     */
    @GetMapping({"/","","/home","/inicio","/index"})
    public String index(Model model) {
        model.addAttribute("nombreTienda", Config.nombreTienda);
        model.addAttribute("contenido","plantilla1");
        return "index";
    }

}
