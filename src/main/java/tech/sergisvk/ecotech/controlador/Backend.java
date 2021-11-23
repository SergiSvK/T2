package tech.sergisvk.ecotech.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Backend {

    @GetMapping({"/adminok"})
    public String ok(Model model) {
        model.addAttribute("mantenimiento", "productos");
        model.addAttribute("titulo", "Listado de categorías");
        return "backend/index";
    }
}
