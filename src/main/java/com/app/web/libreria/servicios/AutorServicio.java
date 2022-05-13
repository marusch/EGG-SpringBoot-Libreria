package com.app.web.libreria.servicios;

import com.app.web.libreria.entidades.Autor;
import java.util.List;

public interface AutorServicio {

    public List<Autor> listarTodosLosAutores();
    
    public Autor guardarAutor(Autor autor);
    
    public Autor obtenerAutorPorId (Long id);
    
    public Autor actualizarAutor(Autor autor);
    
    public void eliminarAutor(Long id);
    
}
