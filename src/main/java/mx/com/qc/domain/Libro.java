package mx.com.qc.domain;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long idLibro;

    private String nombre;

    private String isbn;

    private String autor;

    @Column(name = "no_paginas")
    private int noPaginas;

    private String estatus;

    private String comentarios;
}
