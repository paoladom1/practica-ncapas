package com.uca.capas.domain;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(schema = "public", name= "contribuyente")
public class Contribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_contribuyente")
    private Integer codigoContribuyente;

    @Column(name = "s_nombre")
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 30, message = "El campo no puede tener mas de 30 caracteres")
    private String nombre;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Column(name = "s_apellido")
    @Size(max = 30, message = "El campo no puede tener mas de 30 caracteres")
    private String apellido;

    @Column(name = "s_nit")
    @Size(min = 14, max = 14, message = "El campo debe tener 14 caracteres")
    private String nit;

    @Column(name = "f_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fIngreso;

    @OneToOne
    @JoinColumn(name = "c_importancia")
    private Importancia importancia;

    public Contribuyente() {
    }


    @Override
    public String toString() {
        return "Contribuyente{" +
                "importancia=" + codigoContribuyente +
                '}';
    }

    public Integer getCodigoContribuyente() {
        return codigoContribuyente;
    }

    public void setCodigoContribuyente(Integer codigoContribuyente) {
        this.codigoContribuyente = codigoContribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Importancia getImportancia() {
        return importancia;
    }

    public void setImportancia(Importancia importancia) {
        this.importancia = importancia;
    }

    public Date getfIngreso() {
        return fIngreso;
    }

    public void setfIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }
}

