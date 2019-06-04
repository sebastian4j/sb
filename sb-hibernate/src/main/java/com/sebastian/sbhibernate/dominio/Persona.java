package com.sebastian.sbhibernate.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * representa a la entidad persona.
 *
 * @author Sebastián Ávila A.
 */
@Entity
@Table(name = "persona", schema = ConstantesDominio.ESQUEMA)
public class Persona implements Serializable {

    @Id
    private int id;
    private String nombre;
    @OneToOne
    private Familia familia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
