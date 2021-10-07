package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.domain.Empleado;

public interface IEmpleadoService {
    
    public List<Empleado> listarEmpleados();
    
    public void guardar(Empleado empleado);
    
    public void eliminar(Empleado empleado);
    
    public Empleado encontrarEmpleado(Empleado empleado);
}
