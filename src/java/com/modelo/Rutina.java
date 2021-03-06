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
    private String descripci??nE1;
    @Column(name = "ejercicio2")
    private String ejercicio2;
    @Column(name = "descripci\u00f3n_e2")
    private String descripci??nE2;
    @Column(name = "ejercicio3")
    private String ejercicio3;
    @Column(name = "descripci\u00f3n_e3")
    private String descripci??nE3;
    @Column(name = "ejercicio4")
    private String ejercicio4;
    @Column(name = "descripci\u00f3n_e4")
    private String descripci??nE4;
    @Column(name = "ejercicio5")
    private String ejercicio5;
    @Column(name = "descripci\u00f3n_e5")
    private String descripci??nE5;
    @Column(name = "ejercicio6")
    private String ejercicio6;
    @Column(name = "descripci\u00f3n_e6")
    private String descripci??nE6;
    @Column(name = "ejercicio7")
    private String ejercicio7;
    @Column(name = "descripci\u00f3n_e7")
    private String descripci??nE7;
    @Column(name = "ejercicio8")
    private String ejercicio8;
    @Column(name = "descripci\u00f3n_e8")
    private String descripci??nE8;
    @Column(name = "ejercicio9")
    private String ejercicio9;
    @Column(name = "descripci\u00f3n_e9")
    private String descripci??nE9;
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

    public String getDescripci??nE1() {
        return descripci??nE1;
    }

    public void setDescripci??nE1(String descripci??nE1) {
        this.descripci??nE1 = descripci??nE1;
    }

    public String getEjercicio2() {
        return ejercicio2;
    }

    public void setEjercicio2(String ejercicio2) {
        this.ejercicio2 = ejercicio2;
    }

    public String getDescripci??nE2() {
        return descripci??nE2;
    }

    public void setDescripci??nE2(String descripci??nE2) {
        this.descripci??nE2 = descripci??nE2;
    }

    public String getEjercicio3() {
        return ejercicio3;
    }

    public void setEjercicio3(String ejercicio3) {
        this.ejercicio3 = ejercicio3;
    }

    public String getDescripci??nE3() {
        return descripci??nE3;
    }

    public void setDescripci??nE3(String descripci??nE3) {
        this.descripci??nE3 = descripci??nE3;
    }

    public String getEjercicio4() {
        return ejercicio4;
    }

    public void setEjercicio4(String ejercicio4) {
        this.ejercicio4 = ejercicio4;
    }

    public String getDescripci??nE4() {
        return descripci??nE4;
    }

    public void setDescripci??nE4(String descripci??nE4) {
        this.descripci??nE4 = descripci??nE4;
    }

    public String getEjercicio5() {
        return ejercicio5;
    }

    public void setEjercicio5(String ejercicio5) {
        this.ejercicio5 = ejercicio5;
    }

    public String getDescripci??nE5() {
        return descripci??nE5;
    }

    public void setDescripci??nE5(String descripci??nE5) {
        this.descripci??nE5 = descripci??nE5;
    }

    public String getEjercicio6() {
        return ejercicio6;
    }

    public void setEjercicio6(String ejercicio6) {
        this.ejercicio6 = ejercicio6;
    }

    public String getDescripci??nE6() {
        return descripci??nE6;
    }

    public void setDescripci??nE6(String descripci??nE6) {
        this.descripci??nE6 = descripci??nE6;
    }

    public String getEjercicio7() {
        return ejercicio7;
    }

    public void setEjercicio7(String ejercicio7) {
        this.ejercicio7 = ejercicio7;
    }

    public String getDescripci??nE7() {
        return descripci??nE7;
    }

    public void setDescripci??nE7(String descripci??nE7) {
        this.descripci??nE7 = descripci??nE7;
    }

    public String getEjercicio8() {
        return ejercicio8;
    }

    public void setEjercicio8(String ejercicio8) {
        this.ejercicio8 = ejercicio8;
    }

    public String getDescripci??nE8() {
        return descripci??nE8;
    }

    public void setDescripci??nE8(String descripci??nE8) {
        this.descripci??nE8 = descripci??nE8;
    }

    public String getEjercicio9() {
        return ejercicio9;
    }

    public void setEjercicio9(String ejercicio9) {
        this.ejercicio9 = ejercicio9;
    }

    public String getDescripci??nE9() {
        return descripci??nE9;
    }

    public void setDescripci??nE9(String descripci??nE9) {
        this.descripci??nE9 = descripci??nE9;
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
