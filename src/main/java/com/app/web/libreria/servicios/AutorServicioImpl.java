
package com.app.web.libreria.servicios;

import com.app.web.libreria.entidades.Autor;
import com.app.web.libreria.repositorios.AutorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorServicioImpl implements AutorServicio {
    
    @Autowired
    AutorRepositorio autorRepositorio;
    
    @Override
    public List<Autor> listarTodosLosAutores(){
        return autorRepositorio.findAll();
    }
    
    @Override
    public Autor guardarAutor(Autor autor){
        return autorRepositorio.save(autor);
    }
    
    @Override
    public Autor obtenerAutorPorId(Long id){
        return autorRepositorio.findById(id).get();
    }
    
    @Override
    public Autor actualizarAutor(Autor autor){
        return autorRepositorio.save(autor);
    }
    
    @Override
    public void eliminarAutor(Long id){
        autorRepositorio.deleteById(id);
    }
}
