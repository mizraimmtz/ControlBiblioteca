package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.dao.PrestamoDao;
import mx.com.qc.domain.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrestamoServiceimpl implements IPrestamoService{
    
    @Autowired
    private PrestamoDao prestamoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> listarPrestamos() {
        return (List<Prestamo>) prestamoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Prestamo prestamo) {
        prestamoDao.save(prestamo);
    }

    @Override
    @Transactional
    public void eliminar(Prestamo prestamo) {
        prestamoDao.delete(prestamo);
    }

    @Override
    @Transactional(readOnly = true)
    public Prestamo encontrarPrestamo(Prestamo prestamo) {
        return prestamoDao.findById(prestamo.getIdPrestamo()).orElse(null);
    }
}
