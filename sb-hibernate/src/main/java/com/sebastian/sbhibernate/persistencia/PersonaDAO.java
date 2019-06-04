package com.sebastian.sbhibernate.persistencia;

import com.sebastian.sbhibernate.dominio.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastián Ávila A.
 */
@Component
public class PersonaDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaDAO.class);
    @PersistenceContext
    private EntityManager em;

    public List<Persona> obtener() {
        return em.createQuery("select a from Persona a").getResultList();
    }

    public Persona obtener(final int id) {
        return em.find(Persona.class, id);
    }

    @Transactional
    public void persistir(Persona p) {
        em.persist(p);
    }

    @Transactional
    public void eliminar(Persona p) {
        var persona = em.find(Persona.class, p.getId());
        em.remove(persona);
    }

}
