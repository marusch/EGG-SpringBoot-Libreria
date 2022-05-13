
package com.app.web.libreria.servicios;

import com.app.web.libreria.entidades.Libro;
import java.util.List;

public interface LibroServicio {
    
    public List<Libro> listarTodosLosLibros();
    
    public Libro guardarLibro(Libro libro);
    
    public Libro obtenerLibroPorId (Long id);
    
    public Libro actualizarLibro(Libro libro);
    
    public void eliminarLibro(Long id);
    
}
