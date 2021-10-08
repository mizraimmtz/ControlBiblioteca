package mx.com.qc.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.qc.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import mx.com.qc.servicio.IUsuarioService;


@Controller
@Slf4j
@RequestMapping("/usuario")
public class ControladorUsuarios {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/listarUsuarios")
    public String inicio(Model model){
        var usuarios = usuarioService.listarUsuarios();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("usuarios", usuarios);
        return "/usuario/listarUsuarios";
    }
    
    @GetMapping("/listarUsuarios/agregar")
    public String agregar(Usuario usuario){
        return "/usuario/modificarUsuarios";
    }
    
    @PostMapping("/listarUsuarios/guardar")
    public String guardar(Usuario usuario){
        usuarioService.guardar(usuario);
        return "redirect:/usuario/listarUsuarios";
    }
    
    @GetMapping("/listarUsuarios/editar/{idUsuario}")
    public String editar(Usuario usuario, Model model){
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modificarUsuarios";
    }
    
    @GetMapping("/listarUsuarios/eliminar")
    public String eliminar(Usuario usuario){
        usuarioService.eliminar(usuario);
        return "redirect:/usuario/listarUsuarios";
    }
}
