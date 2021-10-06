package mx.com.qc.dao;

import mx.com.qc.domain.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroDao extends CrudRepository<Libro, Long>{
    
}
