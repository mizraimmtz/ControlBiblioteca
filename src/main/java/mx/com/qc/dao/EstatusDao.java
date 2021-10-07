package mx.com.qc.dao;

import mx.com.qc.domain.Estatus;
import org.springframework.data.repository.CrudRepository;

public interface EstatusDao extends CrudRepository<Estatus, Long>{
    
}
