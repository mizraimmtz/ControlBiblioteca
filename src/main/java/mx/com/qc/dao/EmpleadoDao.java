package mx.com.qc.dao;

import mx.com.qc.domain.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoDao extends CrudRepository<Empleado, Long>{
    
}
