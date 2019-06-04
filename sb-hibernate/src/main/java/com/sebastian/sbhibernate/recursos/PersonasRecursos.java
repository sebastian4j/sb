package com.sebastian.sbhibernate.recursos;

import com.sebastian.sbhibernate.dominio.Persona;
import com.sebastian.sbhibernate.persistencia.PersonaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastián Ávila A.
 */
@RestController
public class PersonasRecursos {

    @Autowired
    private PersonaDAO pdao;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Persona> listar() {
        return pdao.obtener();
    }
}
