package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.dao.EstatusDao;
import mx.com.qc.domain.Estatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatusServiceImpl implements IEstatusService{

    @Autowired
    private EstatusDao estatusDao;
    
    @Override
    public List<Estatus> listaEstatus() {
        return (List<Estatus>) estatusDao.findAll();
    }
    
}
