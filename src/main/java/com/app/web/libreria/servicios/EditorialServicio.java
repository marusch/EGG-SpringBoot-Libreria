package com.app.web.libreria.servicios;

import com.app.web.libreria.entidades.Editorial;
import java.util.List;


public interface EditorialServicio {
    
    
    public List<Editorial> listarTodosLosEditoriales();
    
    public Editorial guardarEditorial(Editorial editorial);
    
    public Editorial obtenerEditorialPorId (Long id);
    
    public Editorial actualizarEditorial(Editorial editorial);
    
    public void eliminarEditorial(Long id);
    
}
