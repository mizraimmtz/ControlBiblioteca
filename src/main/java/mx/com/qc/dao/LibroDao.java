package mx.com.qc.dao;

import java.util.List;
import mx.com.qc.domain.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroDao extends CrudRepository<Libro, Long>{
    
    List<Libro> findByNombre (String nombre);
    
    List<Libro> findByIsbn (String isbn);
}
