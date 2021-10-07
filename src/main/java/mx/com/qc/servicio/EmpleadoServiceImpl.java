package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.dao.EmpleadoDao;
import mx.com.qc.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void eliminar(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
    }
    
}
