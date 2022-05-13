package com.app.web.libreria.controladores;

import com.app.web.libreria.entidades.Autor;
import com.app.web.libreria.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;
    
    @GetMapping("/autores")
    public String listarAutores(Model modelo){
        modelo.addAttribute("autores", autorServicio.listarTodosLosAutores());
        return "autores";
    }
    
     @GetMapping("/autores/nuevo")
    public String crearAutorFormulario(Model modelo){
        Autor autor = new Autor();
        modelo.addAttribute("autor", autor);
                return "crear_autor";
    }
    
    @PostMapping("/autores")
    public String guardarAutor(@ModelAttribute("autor") Autor autor){
        autorServicio.guardarAutor(autor);
        return "redirect:/autores";
    }
    
     @GetMapping("/autores/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("autor", autorServicio.obtenerAutorPorId(id));
        return "editar_autor";
    }
    
     @PostMapping("/autores/{id}")
    public String actualizarAutor(@PathVariable Long id, @ModelAttribute("autor") Autor autor, Model modelo){
        Autor autorExistente = autorServicio.obtenerAutorPorId(id);
        autorExistente.setId(id);
        autorExistente.setNombre(autor.getNombre());
        
        autorServicio.actualizarAutor(autorExistente);
        return "redirect:/autores";
    }
    
    @GetMapping("/autores/{id}")
    public String eliminarAutor(@PathVariable Long id) {
        autorServicio.eliminarAutor(id);
        return "redirect:/autores";
    }
}
