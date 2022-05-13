package com.app.web.libreria.servicios;

import com.app.web.libreria.entidades.Editorial;
import com.app.web.libreria.repositorios.EditorialRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EditorialServicioImpl implements  EditorialServicio{
    
    
    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Override
    public List<Editorial> listarTodosLosEditoriales() {
       return editorialRepositorio.findAll();
    }

    @Override
    public Editorial guardarEditorial(Editorial editorial) {
        return editorialRepositorio.save(editorial);
    }

    @Override
    public Editorial obtenerEditorialPorId(Long id) {
        return editorialRepositorio.findById(id).get();
        
    }

    @Override
    public Editorial actualizarEditorial(Editorial editorial) {
        return editorialRepositorio.save(editorial);
    }

    @Override
    public void eliminarEditorial(Long id) {
         editorialRepositorio.deleteById(id);
    }
    
}
