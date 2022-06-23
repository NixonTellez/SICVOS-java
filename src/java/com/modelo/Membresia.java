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
@Table(name = "membresia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membresia.findAll", query = "SELECT m FROM Membresia m")
    , @NamedQuery(name = "Membresia.findByNumeroMembresia", query = "SELECT m FROM Membresia m WHERE m.numeroMembresia = :numeroMembresia")
    , @NamedQuery(name = "Membresia.findByTipoPlan", query = "SELECT m FROM Membresia m WHERE m.tipoPlan = :tipoPlan")
    , @NamedQuery(name = "Membresia.findByValorPlan", query = "SELECT m FROM Membresia m WHERE m.valorPlan = :valorPlan")
    , @NamedQuery(name = "Membresia.findByFechaInicio", query = "SELECT m FROM Membresia m WHERE m.fechaInicio = :fechaInicio")})
public class Membresia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroMembresia")
    private Integer numeroMembresia;
    @Column(name = "tipoPlan")
    private String tipoPlan;
    @Column(name = "valorPlan")
    private Integer valorPlan;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "diasRestantes", referencedColumnName = "dia")
    @ManyToOne
    private Rutina diasRestantes;

    public Membresia() {
    }

    public Membresia(Integer numeroMembresia) {
        this.numeroMembresia = numeroMembresia;
    }

    public Integer getNumeroMembresia() {
        return numeroMembresia;
    }

    public void setNumeroMembresia(Integer numeroMembresia) {
        this.numeroMembresia = numeroMembresia;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public Integer getValorPlan() {
        return valorPlan;
    }

    public void setValorPlan(Integer valorPlan) {
        this.valorPlan = valorPlan;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rutina getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(Rutina diasRestantes) {
        this.diasRestantes = diasRestantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMembresia != null ? numeroMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membresia)) {
            return false;
        }
        Membresia other = (Membresia) object;
        if ((this.numeroMembresia == null && other.numeroMembresia != null) || (this.numeroMembresia != null && !this.numeroMembresia.equals(other.numeroMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Membresia[ numeroMembresia=" + numeroMembresia + " ]";
    }
    
}
