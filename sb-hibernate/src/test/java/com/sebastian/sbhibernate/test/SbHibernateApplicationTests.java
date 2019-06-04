package com.sebastian.sbhibernate.test;

import com.sebastian.sbhibernate.config.PersistenciaConfig;
import com.sebastian.sbhibernate.dominio.Familia;
import com.sebastian.sbhibernate.dominio.Persona;
import com.sebastian.sbhibernate.persistencia.FamiliaDAO;
import com.sebastian.sbhibernate.persistencia.PersonaDAO;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={PersistenciaConfig.class, PersonaDAO.class, FamiliaDAO.class})
public class SbHibernateApplicationTests {

    @Autowired
    private PersonaDAO pdao;
    @Autowired
    private FamiliaDAO fdao;


    @Test
    public void contextLoads() {
        var p = crearPersona();
        pdao.persistir(p);
        pdao.eliminar(p);
        Assertions.assertThat(pdao.obtener(p.getId())).isNull();
        var p1 = crearPersona();
        var p2 = crearPersona();
        var fam = new Familia();
        fam.setPapa(p1);
        fam.setMama(p2);
        pdao.persistir(p1);
        pdao.persistir(p2);
        fdao.persistir(fam);
        fdao.eliminar(fam);
        pdao.eliminar(p1);
        pdao.eliminar(p2);
    }

    private Persona crearPersona() {
        var p = new Persona();
        p.setId(ThreadLocalRandom.current().nextInt());
        p.setNombre(UUID.randomUUID().toString());
        return p;
    }
}
