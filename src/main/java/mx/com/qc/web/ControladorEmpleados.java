package mx.com.qc.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.qc.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mx.com.qc.servicio.IEmpleadoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/listar")
public class ControladorEmpleados {
    
    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/listarEmpleados")
    public String inicio(Model model){
        var empleados = empleadoService.listarEmpleados();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("empleados", empleados);
        return "listar/listarEmpleados";
    }
    
    @GetMapping("/listarEmpleados/agregar")
    public String agregar(Empleado empleado){
        return "listar/modificarEmpleados";
    }
    
    @PostMapping("/listarEmpleados/guardar")
    public String guardar(Empleado empleado){
        empleadoService.guardar(empleado);
        return "redirect:/listar/listarEmpleados";
    }
    
    @GetMapping("/listarEmpleados/editar/{idEmpleado}")
    public String editar(Empleado empleado, Model model){
        empleado = empleadoService.encontrarEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        return "listar/modificarEmpleados";
    }
    
    @GetMapping("/listarEmpleados/eliminar")
    public String eliminar(Empleado empleado){
        empleadoService.eliminar(empleado);
        return "redirect:/listar/listarEmpleados";
    }
}
