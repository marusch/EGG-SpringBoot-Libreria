package com.app.web.libreria.controladores;

import com.app.web.libreria.entidades.Editorial;
import com.app.web.libreria.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialServicio;
    
    @GetMapping("/editoriales")
    public String listarEditoriales(Model modelo){
        modelo.addAttribute("editoriales", editorialServicio.listarTodosLosEditoriales());
        return "editoriales";
    }
    
     @GetMapping("/editoriales/nuevo")
    public String crearEditorialFormulario(Model modelo){
        Editorial editorial = new Editorial();
        modelo.addAttribute("editorial", editorial);
                return "crear_editorial";
    }
    
    @PostMapping("/editoriales")
    public String guardarEditorial(@ModelAttribute("editorial") Editorial editorial){
        editorialServicio.guardarEditorial(editorial);
        return "redirect:/editoriales";
    }
    
     @GetMapping("/editoriales/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("editorial", editorialServicio.obtenerEditorialPorId(id));
        return "editar_editorial";
    }
    
     @PostMapping("/editoriales/{id}")
    public String actualizarEditorial(@PathVariable Long id, @ModelAttribute("editorial") Editorial editorial, Model modelo){
     
        Editorial editorialExistente = editorialServicio.obtenerEditorialPorId(id);
        editorialExistente.setId(id);
        editorialExistente.setNombre(editorial.getNombre());
        
        editorialServicio.actualizarEditorial(editorialExistente);
        return "redirect:/editoriales";
    }
    
    @GetMapping("/editoriales/{id}")
    public String eliminarEditorial(@PathVariable Long id) {
        editorialServicio.eliminarEditorial(id);
        return "redirect:/editoriales";
    }
}
