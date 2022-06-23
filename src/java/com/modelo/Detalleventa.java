/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 10 Spring Creators
 */
@Entity
@Table(name = "detalleventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d")
    , @NamedQuery(name = "Detalleventa.findByNumDetalle", query = "SELECT d FROM Detalleventa d WHERE d.numDetalle = :numDetalle")
    , @NamedQuery(name = "Detalleventa.findByCantidad", query = "SELECT d FROM Detalleventa d WHERE d.cantidad = :cantidad")})
public class Detalleventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numDetalle")
    private Integer numDetalle;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "numeroFactura", referencedColumnName = "numeroFactura")
    @ManyToOne(optional = false)
    private Ordencompra numeroFactura;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Detalleventa() {
    }

    public Detalleventa(Integer numDetalle) {
        this.numDetalle = numDetalle;
    }

    public Detalleventa(Integer numDetalle, int cantidad) {
        this.numDetalle = numDetalle;
        this.cantidad = cantidad;
    }

    public Integer getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(Integer numDetalle) {
        this.numDetalle = numDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ordencompra getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Ordencompra numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numDetalle != null ? numDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.numDetalle == null && other.numDetalle != null) || (this.numDetalle != null && !this.numDetalle.equals(other.numDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Detalleventa[ numDetalle=" + numDetalle + " ]";
    }
    
}
