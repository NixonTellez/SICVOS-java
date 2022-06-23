/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 10 Spring Creators
 */
@Entity
@Table(name = "pqrs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqrs.findAll", query = "SELECT p FROM Pqrs p")
    , @NamedQuery(name = "Pqrs.findByNumeroPQRS", query = "SELECT p FROM Pqrs p WHERE p.numeroPQRS = :numeroPQRS")
    , @NamedQuery(name = "Pqrs.findByTipo", query = "SELECT p FROM Pqrs p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Pqrs.findByDescripcion", query = "SELECT p FROM Pqrs p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pqrs.findByFecha", query = "SELECT p FROM Pqrs p WHERE p.fecha = :fecha")})
public class Pqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_PQRS")
    private Integer numeroPQRS;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Pqrs() {
    }

    public Pqrs(Integer numeroPQRS) {
        this.numeroPQRS = numeroPQRS;
    }

    public Integer getNumeroPQRS() {
        return numeroPQRS;
    }

    public void setNumeroPQRS(Integer numeroPQRS) {
        this.numeroPQRS = numeroPQRS;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPQRS != null ? numeroPQRS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqrs)) {
            return false;
        }
        Pqrs other = (Pqrs) object;
        if ((this.numeroPQRS == null && other.numeroPQRS != null) || (this.numeroPQRS != null && !this.numeroPQRS.equals(other.numeroPQRS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Pqrs[ numeroPQRS=" + numeroPQRS + " ]";
    }
    
}
