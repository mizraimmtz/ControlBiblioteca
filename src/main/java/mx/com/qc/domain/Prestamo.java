package mx.com.qc.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "prestamos")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long idPrestamo;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleados;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarios;
    
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libros;
    
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaSalida;
    
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaDevolucion;
}
