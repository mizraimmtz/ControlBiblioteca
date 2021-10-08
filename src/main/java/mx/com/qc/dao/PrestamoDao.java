package mx.com.qc.dao;

import mx.com.qc.domain.Prestamo;
import org.springframework.data.repository.CrudRepository;

public interface PrestamoDao extends CrudRepository<Prestamo, Long>{
    
}
