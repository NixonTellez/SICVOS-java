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
@Table(name = "novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n")
    , @NamedQuery(name = "Novedad.findByNumNovedad", query = "SELECT n FROM Novedad n WHERE n.numNovedad = :numNovedad")
    , @NamedQuery(name = "Novedad.findByTipoNovedad", query = "SELECT n FROM Novedad n WHERE n.tipoNovedad = :tipoNovedad")
    , @NamedQuery(name = "Novedad.findByDescripcion", query = "SELECT n FROM Novedad n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Novedad.findByFecha", query = "SELECT n FROM Novedad n WHERE n.fecha = :fecha")})
public class Novedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numNovedad")
    private Integer numNovedad;
    @Column(name = "tipo_novedad")
    private String tipoNovedad;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idMaquina", referencedColumnName = "idMaquina")
    @ManyToOne(optional = false)
    private Maquina idMaquina;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Novedad() {
    }

    public Novedad(Integer numNovedad) {
        this.numNovedad = numNovedad;
    }

    public Integer getNumNovedad() {
        return numNovedad;
    }

    public void setNumNovedad(Integer numNovedad) {
        this.numNovedad = numNovedad;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(String tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
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

    public Maquina getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquina idMaquina) {
        this.idMaquina = idMaquina;
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
        hash += (numNovedad != null ? numNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.numNovedad == null && other.numNovedad != null) || (this.numNovedad != null && !this.numNovedad.equals(other.numNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Novedad[ numNovedad=" + numNovedad + " ]";
    }
    
}
