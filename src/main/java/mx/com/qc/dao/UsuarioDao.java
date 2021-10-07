package mx.com.qc.dao;

import mx.com.qc.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    
}
