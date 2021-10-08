package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.domain.Prestamo;

public interface IPrestamoService {

public List<Prestamo> listarPrestamos();
    
    public void guardar(Prestamo prestamo);
    
    public void eliminar(Prestamo prestamo);
    
    public Prestamo encontrarPrestamo(Prestamo prestamo);    
}
