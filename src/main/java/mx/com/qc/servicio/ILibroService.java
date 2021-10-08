package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.domain.Libro;

public interface ILibroService {
    
    public List<Libro> listarLibros();
    
    public void guardar(Libro libro);
    
    public void eliminar(Libro libro);
    
    public Libro encontrarLibro(Libro libro);
    
    List<Libro> buscarPorNombre (String nombre);
}
