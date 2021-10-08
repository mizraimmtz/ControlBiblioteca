package mx.com.qc.servicio;

import java.util.List;
import mx.com.qc.domain.Usuario;

public interface IUsuarioService {
    
    public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Usuario encontrarUsuario(Usuario usuario);
}
