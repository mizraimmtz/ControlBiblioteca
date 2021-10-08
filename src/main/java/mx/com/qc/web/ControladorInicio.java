package mx.com.qc.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.qc.domain.Estatus;
import mx.com.qc.domain.Libro;
import mx.com.qc.servicio.IEstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import mx.com.qc.servicio.ILibroService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private ILibroService libroService;

    @Autowired
    private IEstatusService estatusService;

    @GetMapping("/")
    public String inicio(Model model) {
        var libros = libroService.listarLibros();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("libros", libros);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Model model, Libro libro) {
        List<Estatus> listEstatus = estatusService.listaEstatus();
        model.addAttribute("libro", libro);
        model.addAttribute("estatus", listEstatus);
        return "agregar";
    }

    @PostMapping("/guardar")
    public String guardar(Libro libro) {
        libroService.guardar(libro);
        return "redirect:/";
    }

    @GetMapping("/editar/{idLibro}")
    public String editar(Libro libro, Model model) {
        List<Estatus> listEstatus = estatusService.listaEstatus();
        libro = libroService.encontrarLibro(libro);
        model.addAttribute("libro", libro);
        model.addAttribute("estatus", listEstatus);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Libro libro) {
        libroService.eliminar(libro);
        return "redirect:/";
    }

    @GetMapping("/nombresform")
    public String nombresform(Model model) {
        model.addAttribute("libro", new Libro());
        return "nombreform";
    }

    @GetMapping("/isbnsform")
    public String isbnsform(Model model) {
        model.addAttribute("libro", new Libro());
        return "isbnform";
    }

    @GetMapping("/nombre")
    public String buscarPorNombre(@RequestParam String nombre, Model model, @ModelAttribute("libro") Libro libro) {
        model.addAttribute("librosPorNombre", libroService.buscarPorNombre(nombre));
        return "nombreform";
    }

    @GetMapping("/isbn")
    public String buscarPorIsbn(@RequestParam String isbn, Model model, @ModelAttribute("libro") Libro libro) {
        model.addAttribute("librosPorIsbn", libroService.buscarPorIsbn(isbn));
        return "isbnform";
    }
}
