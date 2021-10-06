package mx.com.qc.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.qc.domain.Libro;
import mx.com.qc.servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private LibroService plibroService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var libros = plibroService.listarLibros();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("libros", libros);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Libro libro){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Libro libro){
        plibroService.guardar(libro);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idLibro}")
    public String editar(Libro libro, Model model){
        libro = plibroService.encontrarLibro(libro);
        model.addAttribute("libro", libro);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Libro libro){
        plibroService.eliminar(libro);
        return "redirect:/";
    }
}
