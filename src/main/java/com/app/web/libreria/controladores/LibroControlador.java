package com.app.web.libreria.controladores;

import com.app.web.libreria.entidades.Autor;
import com.app.web.libreria.entidades.Editorial;
import com.app.web.libreria.entidades.Libro;
import com.app.web.libreria.servicios.AutorServicio;
import com.app.web.libreria.servicios.EditorialServicio;

import com.app.web.libreria.servicios.LibroServicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping("/")
    public String paginaPrincipal(){
        return "index";
    }
    
    @GetMapping("/libros")
    public String listarLibros(Model modelo) {
        modelo.addAttribute("libros", libroServicio.listarTodosLosLibros());
        return "libros";
    }

    @GetMapping("/libros/nuevo")
    public String crearLibroFormulario(Model modelo) {
        Libro libro = new Libro();
        List<Autor> listaAutores = autorServicio.listarTodosLosAutores();
        List<Editorial> listaEditoriales = editorialServicio.listarTodosLosEditoriales();

        modelo.addAttribute("libro", libro);
        modelo.addAttribute("autores", listaAutores);
        modelo.addAttribute("editoriales", listaEditoriales);
        return "crear_libro";
    }

    @PostMapping("/libros")
    public String guardarLibro(@ModelAttribute("libro") Libro libro) {
        libroServicio.guardarLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/libros/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("libro", libroServicio.obtenerLibroPorId(id));
        return "editar_libro";
    }

    @PostMapping("/libros/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro, Model modelo) {
        Libro libroExistente = libroServicio.obtenerLibroPorId(id);

        libroExistente.setIsbn(libro.getIsbn());
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAnio(libro.getAnio());
        libroExistente.setEjemplares(libro.getEjemplares());
        libroExistente.setEjemplaresPrestados(libro.getEjemplaresPrestados());

        libroServicio.actualizarLibro(libroExistente);
        return "redirect:/libros";
    }

    @GetMapping("/libros/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroServicio.eliminarLibro(id);
        return "redirect:/libros";
    }
}
