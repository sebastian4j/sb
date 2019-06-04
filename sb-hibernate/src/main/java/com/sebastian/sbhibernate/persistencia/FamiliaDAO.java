package com.sebastian.sbhibernate.persistencia;

import com.sebastian.sbhibernate.dominio.Familia;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastián Ávila A.
 */
@Component
public class FamiliaDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persistir(final Familia fam) {
        em.persist(fam);
    }

    @Transactional
    public void eliminar(final Familia fam) {
        em.remove(fam);
    }
}
