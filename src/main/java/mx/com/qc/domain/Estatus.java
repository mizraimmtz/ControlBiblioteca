package mx.com.qc.domain;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "estatus")
public class Estatus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estatus")
    private Long idEstatus;
    
    @Column(name = "estatus_libro")
    private String estatusLibro;
}
