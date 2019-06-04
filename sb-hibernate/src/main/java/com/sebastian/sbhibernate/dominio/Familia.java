package com.sebastian.sbhibernate.dominio;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sebastián Ávila A.
 */
@Entity
@Table(name = "familia", schema = ConstantesDominio.ESQUEMA)
public class Familia implements Serializable {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private Persona papa;
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private Persona mama;
    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private Set<Persona> hijos;

    public Persona getPapa() {
        return papa;
    }

    public void setPapa(Persona papa) {
        this.papa = papa;
    }

    public Persona getMama() {
        return mama;
    }

    public void setMama(Persona mama) {
        this.mama = mama;
    }

    public Set<Persona> getHijos() {
        return hijos;
    }

    public void setHijos(Set<Persona> hijos) {
        this.hijos = hijos;
    }

}
