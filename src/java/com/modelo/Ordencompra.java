/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 10 Spring Creators
 */
@Entity
@Table(name = "ordencompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o")
    , @NamedQuery(name = "Ordencompra.findByNumeroFactura", query = "SELECT o FROM Ordencompra o WHERE o.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "Ordencompra.findByFecha", query = "SELECT o FROM Ordencompra o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Ordencompra.findByValor", query = "SELECT o FROM Ordencompra o WHERE o.valor = :valor")
    , @NamedQuery(name = "Ordencompra.findByTipoPago", query = "SELECT o FROM Ordencompra o WHERE o.tipoPago = :tipoPago")})
public class Ordencompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroFactura")
    private Integer numeroFactura;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "valor")
    private Integer valor;
    @Basic(optional = false)
    @Column(name = "tipoPago")
    private String tipoPago;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroFactura")
    private Collection<Detalleventa> detalleventaCollection;

    public Ordencompra() {
    }

    public Ordencompra(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Ordencompra(Integer numeroFactura, String tipoPago) {
        this.numeroFactura = numeroFactura;
        this.tipoPago = tipoPago;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Detalleventa> getDetalleventaCollection() {
        return detalleventaCollection;
    }

    public void setDetalleventaCollection(Collection<Detalleventa> detalleventaCollection) {
        this.detalleventaCollection = detalleventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFactura != null ? numeroFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Ordencompra[ numeroFactura=" + numeroFactura + " ]";
    }
    
}
