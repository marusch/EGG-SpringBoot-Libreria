
package com.app.web.libreria.repositorios;

import com.app.web.libreria.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long>{
    
}
