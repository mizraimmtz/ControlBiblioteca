package mx.com.qc.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mx.com.qc.servicio.IEmpleadoService;


@Controller
@Slf4j
public class ControladorEmpleados {
    
    @Autowired
    private IEmpleadoService empleadoService;
}
