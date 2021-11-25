package tech.sergisvk.ecotech.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.sergisvk.ecotech.servicios.ProductoService;
import tech.sergisvk.ecotech.utilidades.Util;

@Controller
public class Backend {

    @GetMapping({"/adminok","/admin"})
    public String adminok(Model model) {
        model.addAttribute("nameShop", Util.host());
        model.addAttribute("mantenimiento", "productos");
        model.addAttribute("titulo", "Listado de categorías");
        return "backend/index";
    }

    @GetMapping({"/admin/tables"})
    public String tables(Model model) {
        model.addAttribute("nameShop", Util.host());
        model.addAttribute("mantenimiento", "productos");
        model.addAttribute("titulo", "Listado de categorías");
        return "backend/tables";
    }

    @GetMapping({"/productos"})
    public String productos(Model model) {
        ProductoService productoService = new ProductoService();
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("titulo","Tienda de ....");
        model.addAttribute("contenido","productos");
        return "backend/productos";
    }
}
