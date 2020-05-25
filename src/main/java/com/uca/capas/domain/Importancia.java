package com.uca.capas.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {

    @Id
    @Column(name = "c_importancia")
    private Integer codigoImportancia;

    @Column(name = "s_importancia")
    private String nombre;

    public Importancia() {
    }

    @Override
    public String toString() {
        return "Importancia{" +
                "codigoImportancia=" + codigoImportancia +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Integer getCodigoImportancia() {
        return codigoImportancia;
    }

    public void setCodigoImportancia(Integer codigoImportancia) {
        this.codigoImportancia = codigoImportancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
