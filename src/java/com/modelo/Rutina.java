/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "rutina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutina.findAll", query = "SELECT r FROM Rutina r")
    , @NamedQuery(name = "Rutina.findByDia", query = "SELECT r FROM Rutina r WHERE r.dia = :dia")
    , @NamedQuery(name = "Rutina.findByEjercicio1", query = "SELECT r FROM Rutina r WHERE r.ejercicio1 = :ejercicio1")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE1", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE1 = :descripci\u00f3nE1")
    , @NamedQuery(name = "Rutina.findByEjercicio2", query = "SELECT r FROM Rutina r WHERE r.ejercicio2 = :ejercicio2")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE2", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE2 = :descripci\u00f3nE2")
    , @NamedQuery(name = "Rutina.findByEjercicio3", query = "SELECT r FROM Rutina r WHERE r.ejercicio3 = :ejercicio3")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE3", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE3 = :descripci\u00f3nE3")
    , @NamedQuery(name = "Rutina.findByEjercicio4", query = "SELECT r FROM Rutina r WHERE r.ejercicio4 = :ejercicio4")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE4", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE4 = :descripci\u00f3nE4")
    , @NamedQuery(name = "Rutina.findByEjercicio5", query = "SELECT r FROM Rutina r WHERE r.ejercicio5 = :ejercicio5")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE5", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE5 = :descripci\u00f3nE5")
    , @NamedQuery(name = "Rutina.findByEjercicio6", query = "SELECT r FROM Rutina r WHERE r.ejercicio6 = :ejercicio6")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE6", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE6 = :descripci\u00f3nE6")
    , @NamedQuery(name = "Rutina.findByEjercicio7", query = "SELECT r FROM Rutina r WHERE r.ejercicio7 = :ejercicio7")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE7", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE7 = :descripci\u00f3nE7")
    , @NamedQuery(name = "Rutina.findByEjercicio8", query = "SELECT r FROM Rutina r WHERE r.ejercicio8 = :ejercicio8")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE8", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE8 = :descripci\u00f3nE8")
    , @NamedQuery(name = "Rutina.findByEjercicio9", query = "SELECT r FROM Rutina r WHERE r.ejercicio9 = :ejercicio9")
    , @NamedQuery(name = "Rutina.findByDescripci\u00f3nE9", query = "SELECT r FROM Rutina r WHERE r.descripci\u00f3nE9 = :descripci\u00f3nE9")})
public class Rutina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dia")
    private Integer dia;
    @Column(name = "ejercicio1")
    private String ejercicio1;
    @Column(name = "descripci\u00f3n_e1")
    private String descripciónE1;
    @Column(name = "ejercicio2")
    private String ejercicio2;
    @Column(name = "descripci\u00f3n_e2")
    private String descripciónE2;
    @Column(name = "ejercicio3")
    private String ejercicio3;
    @Column(name = "descripci\u00f3n_e3")
    private String descripciónE3;
    @Column(name = "ejercicio4")
    private String ejercicio4;
    @Column(name = "descripci\u00f3n_e4")
    private String descripciónE4;
    @Column(name = "ejercicio5")
    private String ejercicio5;
    @Column(name = "descripci\u00f3n_e5")
    private String descripciónE5;
    @Column(name = "ejercicio6")
    private String ejercicio6;
    @Column(name = "descripci\u00f3n_e6")
    private String descripciónE6;
    @Column(name = "ejercicio7")
    private String ejercicio7;
    @Column(name = "descripci\u00f3n_e7")
    private String descripciónE7;
    @Column(name = "ejercicio8")
    private String ejercicio8;
    @Column(name = "descripci\u00f3n_e8")
    private String descripciónE8;
    @Column(name = "ejercicio9")
    private String ejercicio9;
    @Column(name = "descripci\u00f3n_e9")
    private String descripciónE9;
    @OneToMany(mappedBy = "diasRestantes")
    private Collection<Membresia> membresiaCollection;

    public Rutina() {
    }

    public Rutina(Integer dia) {
        this.dia = dia;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public String getEjercicio1() {
        return ejercicio1;
    }

    public void setEjercicio1(String ejercicio1) {
        this.ejercicio1 = ejercicio1;
    }

    public String getDescripciónE1() {
        return descripciónE1;
    }

    public void setDescripciónE1(String descripciónE1) {
        this.descripciónE1 = descripciónE1;
    }

    public String getEjercicio2() {
        return ejercicio2;
    }

    public void setEjercicio2(String ejercicio2) {
        this.ejercicio2 = ejercicio2;
    }

    public String getDescripciónE2() {
        return descripciónE2;
    }

    public void setDescripciónE2(String descripciónE2) {
        this.descripciónE2 = descripciónE2;
    }

    public String getEjercicio3() {
        return ejercicio3;
    }

    public void setEjercicio3(String ejercicio3) {
        this.ejercicio3 = ejercicio3;
    }

    public String getDescripciónE3() {
        return descripciónE3;
    }

    public void setDescripciónE3(String descripciónE3) {
        this.descripciónE3 = descripciónE3;
    }

    public String getEjercicio4() {
        return ejercicio4;
    }

    public void setEjercicio4(String ejercicio4) {
        this.ejercicio4 = ejercicio4;
    }

    public String getDescripciónE4() {
        return descripciónE4;
    }

    public void setDescripciónE4(String descripciónE4) {
        this.descripciónE4 = descripciónE4;
    }

    public String getEjercicio5() {
        return ejercicio5;
    }

    public void setEjercicio5(String ejercicio5) {
        this.ejercicio5 = ejercicio5;
    }

    public String getDescripciónE5() {
        return descripciónE5;
    }

    public void setDescripciónE5(String descripciónE5) {
        this.descripciónE5 = descripciónE5;
    }

    public String getEjercicio6() {
        return ejercicio6;
    }

    public void setEjercicio6(String ejercicio6) {
        this.ejercicio6 = ejercicio6;
    }

    public String getDescripciónE6() {
        return descripciónE6;
    }

    public void setDescripciónE6(String descripciónE6) {
        this.descripciónE6 = descripciónE6;
    }

    public String getEjercicio7() {
        return ejercicio7;
    }

    public void setEjercicio7(String ejercicio7) {
        this.ejercicio7 = ejercicio7;
    }

    public String getDescripciónE7() {
        return descripciónE7;
    }

    public void setDescripciónE7(String descripciónE7) {
        this.descripciónE7 = descripciónE7;
    }

    public String getEjercicio8() {
        return ejercicio8;
    }

    public void setEjercicio8(String ejercicio8) {
        this.ejercicio8 = ejercicio8;
    }

    public String getDescripciónE8() {
        return descripciónE8;
    }

    public void setDescripciónE8(String descripciónE8) {
        this.descripciónE8 = descripciónE8;
    }

    public String getEjercicio9() {
        return ejercicio9;
    }

    public void setEjercicio9(String ejercicio9) {
        this.ejercicio9 = ejercicio9;
    }

    public String getDescripciónE9() {
        return descripciónE9;
    }

    public void setDescripciónE9(String descripciónE9) {
        this.descripciónE9 = descripciónE9;
    }

    @XmlTransient
    public Collection<Membresia> getMembresiaCollection() {
        return membresiaCollection;
    }

    public void setMembresiaCollection(Collection<Membresia> membresiaCollection) {
        this.membresiaCollection = membresiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dia != null ? dia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutina)) {
            return false;
        }
        Rutina other = (Rutina) object;
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Rutina[ dia=" + dia + " ]";
    }
    
}
