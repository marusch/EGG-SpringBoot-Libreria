
package com.app.web.libreria.servicios;

import com.app.web.libreria.entidades.Libro;
import com.app.web.libreria.repositorios.LibroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicioImpl implements LibroServicio{
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Override
    public List<Libro> listarTodosLosLibros(){
        return libroRepositorio.findAll();
    }
    
    @Override
    public Libro guardarLibro(Libro libro){
        return libroRepositorio.save(libro);
    }
    
    @Override
    public Libro obtenerLibroPorId(Long id){
        return libroRepositorio.findById(id).get();
    }
    
    @Override
    public Libro actualizarLibro(Libro libro){
        return libroRepositorio.save(libro);
    }
    
    @Override
    public void eliminarLibro(Long id){
        libroRepositorio.deleteById(id);
    }
}
