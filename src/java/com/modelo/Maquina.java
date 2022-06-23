/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 10 Spring Creators
 */
@Entity
@Table(name = "maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m")
    , @NamedQuery(name = "Maquina.findByIdMaquina", query = "SELECT m FROM Maquina m WHERE m.idMaquina = :idMaquina")
    , @NamedQuery(name = "Maquina.findByNombre", query = "SELECT m FROM Maquina m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Maquina.findByEstado", query = "SELECT m FROM Maquina m WHERE m.estado = :estado")})
public class Maquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMaquina")
    private Integer idMaquina;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaquina")
    private Collection<Novedad> novedadCollection;

    public Maquina() {
    }

    public Maquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Novedad> getNovedadCollection() {
        return novedadCollection;
    }

    public void setNovedadCollection(Collection<Novedad> novedadCollection) {
        this.novedadCollection = novedadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquina != null ? idMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.idMaquina == null && other.idMaquina != null) || (this.idMaquina != null && !this.idMaquina.equals(other.idMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Maquina[ idMaquina=" + idMaquina + " ]";
    }
    
}
