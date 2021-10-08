package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.dao.LibroDao;
import mx.com.qc.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    private LibroDao libroDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    @Transactional
    public void eliminar(Libro libro) {
        libroDao.delete(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro encontrarLibro(Libro libro) {
        return libroDao.findById(libro.getIdLibro()).orElse(null);
    }

    @Override
    public List<Libro> buscarPorNombre(String nombre) {
        return libroDao.findByNombre(nombre);
    }

    @Override
    public List<Libro> buscarPorIsbn(String isbn) {
        return libroDao.findByIsbn(isbn);
    }

}
