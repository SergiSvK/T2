package tech.sergisvk.t2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.sergisvk.t2.DominioSesion;

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

    /**
     *
     * @return
     */
    @GetMapping({"/holamundo"})
    public String holaMundo() {
        return "holamundo";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping({"/","","/home","/inicio","/index"})
    public String index(Model model) {
        model.addAttribute("titulo","Tienda de ....");
        model.addAttribute("contenido","plantilla1");
        return "index";
    }

    @GetMapping({"/categorias"})
    public String categorias(Model model) {
        model.addAttribute("titulo","Tienda de ....");
        model.addAttribute("contenido","categorias");
        return "index";
    }

    @GetMapping({"/intranet"})
    public String intranet(Model model) {
        model.addAttribute("titulo","Tienda de ....");
        model.addAttribute("contenido","categorias");
        return "index_intranet";
    }


    //Imágenes
    @GetMapping({"/mvc"})
    public String mvc(Model model) {
        model.addAttribute("titulo","Tienda de ....");
        return "info/mvc";
    }

    @GetMapping({"/clases"})
    public String clases(Model model) {
        model.addAttribute("titulo","Tienda de ....");
        return "info/clases";
    }

}
