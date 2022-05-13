
package com.app.web.libreria.repositorios;

import com.app.web.libreria.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Long>{
    
}
