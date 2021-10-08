package mx.com.qc.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.qc.domain.Empleado;
import mx.com.qc.domain.*;
import mx.com.qc.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequestMapping("/prestamo")
public class ControladorPrestamos {
    
    @Autowired
    private IPrestamoService prestamoService;
    
    @Autowired
    private IEmpleadoService empleadoService;
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    private ILibroService libroService;
    
    @GetMapping("/listarPrestamos")
    public String inicio(Model model){
        var prestamos = prestamoService.listarPrestamos();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("prestamos", prestamos);
        return "/prestamo/listarPrestamos";
    }
    
    @GetMapping("/listarPrestamos/agregar")
    public String agregar(Model model, Prestamo prestamo){
        List<Empleado> listEspleado = empleadoService.listarEmpleados();
        List<Usuario> listUsuario = usuarioService.listarUsuarios();
        List<Libro> listLibro = libroService.listarLibros();
        model.addAttribute("prestamo", prestamo);
        model.addAttribute("empleados", listEspleado);
        model.addAttribute("usuarios", listUsuario);
        model.addAttribute("libros", listLibro);
        return "/prestamo/agregarPrestamo";
    }
    
    @PostMapping("/guardar")
    public String guardar(Prestamo prestamo){
        prestamoService.guardar(prestamo);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idLibro}")
    public String editar(Prestamo prestamo, Model model){
        List<Empleado> listEspleado = empleadoService.listarEmpleados();
        List<Usuario> listUsuario = usuarioService.listarUsuarios();
        List<Libro> listLibro = libroService.listarLibros();
        prestamo = prestamoService.encontrarPrestamo(prestamo);
        model.addAttribute("prestamo", prestamo);
        model.addAttribute("empleados", listEspleado);
        model.addAttribute("usuarios", listUsuario);
        model.addAttribute("libros", listLibro);
        return "modificar";
    }
    

}
