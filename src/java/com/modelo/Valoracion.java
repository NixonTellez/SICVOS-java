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
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByNumeroValoracion", query = "SELECT v FROM Valoracion v WHERE v.numeroValoracion = :numeroValoracion")
    , @NamedQuery(name = "Valoracion.findByFecha", query = "SELECT v FROM Valoracion v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Valoracion.findByCuello", query = "SELECT v FROM Valoracion v WHERE v.cuello = :cuello")
    , @NamedQuery(name = "Valoracion.findByPecho", query = "SELECT v FROM Valoracion v WHERE v.pecho = :pecho")
    , @NamedQuery(name = "Valoracion.findByEspalda", query = "SELECT v FROM Valoracion v WHERE v.espalda = :espalda")
    , @NamedQuery(name = "Valoracion.findByABDsuperior", query = "SELECT v FROM Valoracion v WHERE v.aBDsuperior = :aBDsuperior")
    , @NamedQuery(name = "Valoracion.findByABDinferior", query = "SELECT v FROM Valoracion v WHERE v.aBDinferior = :aBDinferior")
    , @NamedQuery(name = "Valoracion.findByGluteo", query = "SELECT v FROM Valoracion v WHERE v.gluteo = :gluteo")
    , @NamedQuery(name = "Valoracion.findByBrazoI", query = "SELECT v FROM Valoracion v WHERE v.brazoI = :brazoI")
    , @NamedQuery(name = "Valoracion.findByBrazoD", query = "SELECT v FROM Valoracion v WHERE v.brazoD = :brazoD")
    , @NamedQuery(name = "Valoracion.findByAntebrazoI", query = "SELECT v FROM Valoracion v WHERE v.antebrazoI = :antebrazoI")
    , @NamedQuery(name = "Valoracion.findByAntebrazoD", query = "SELECT v FROM Valoracion v WHERE v.antebrazoD = :antebrazoD")
    , @NamedQuery(name = "Valoracion.findByMusloI", query = "SELECT v FROM Valoracion v WHERE v.musloI = :musloI")
    , @NamedQuery(name = "Valoracion.findByMusloD", query = "SELECT v FROM Valoracion v WHERE v.musloD = :musloD")
    , @NamedQuery(name = "Valoracion.findByPantorrilaI", query = "SELECT v FROM Valoracion v WHERE v.pantorrilaI = :pantorrilaI")
    , @NamedQuery(name = "Valoracion.findByPantorrillaD", query = "SELECT v FROM Valoracion v WHERE v.pantorrillaD = :pantorrillaD")
    , @NamedQuery(name = "Valoracion.findByPeso", query = "SELECT v FROM Valoracion v WHERE v.peso = :peso")
    , @NamedQuery(name = "Valoracion.findByPorcentajegrasa", query = "SELECT v FROM Valoracion v WHERE v.porcentajegrasa = :porcentajegrasa")
    , @NamedQuery(name = "Valoracion.findByPorcentajeagua", query = "SELECT v FROM Valoracion v WHERE v.porcentajeagua = :porcentajeagua")
    , @NamedQuery(name = "Valoracion.findByPorcentajemusculo", query = "SELECT v FROM Valoracion v WHERE v.porcentajemusculo = :porcentajemusculo")
    , @NamedQuery(name = "Valoracion.findByPorcentajeoseo", query = "SELECT v FROM Valoracion v WHERE v.porcentajeoseo = :porcentajeoseo")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroValoracion")
    private Integer numeroValoracion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "cuello")
    private String cuello;
    @Column(name = "pecho")
    private String pecho;
    @Column(name = "espalda")
    private String espalda;
    @Column(name = "ABD_superior")
    private String aBDsuperior;
    @Column(name = "ABD_inferior")
    private String aBDinferior;
    @Column(name = "Gluteo")
    private String gluteo;
    @Column(name = "Brazo_I")
    private String brazoI;
    @Column(name = "Brazo_D")
    private String brazoD;
    @Column(name = "Antebrazo_I")
    private String antebrazoI;
    @Column(name = "Antebrazo_D")
    private String antebrazoD;
    @Column(name = "Muslo_I")
    private String musloI;
    @Column(name = "Muslo_D")
    private String musloD;
    @Column(name = "Pantorrila_I")
    private String pantorrilaI;
    @Column(name = "Pantorrilla_D")
    private String pantorrillaD;
    @Column(name = "Peso")
    private String peso;
    @Column(name = "Porcentaje_grasa")
    private String porcentajegrasa;
    @Column(name = "Porcentaje_agua")
    private String porcentajeagua;
    @Column(name = "Porcentaje_musculo")
    private String porcentajemusculo;
    @Column(name = "Porcentaje_oseo")
    private String porcentajeoseo;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Valoracion() {
    }

    public Valoracion(Integer numeroValoracion) {
        this.numeroValoracion = numeroValoracion;
    }

    public Integer getNumeroValoracion() {
        return numeroValoracion;
    }

    public void setNumeroValoracion(Integer numeroValoracion) {
        this.numeroValoracion = numeroValoracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCuello() {
        return cuello;
    }

    public void setCuello(String cuello) {
        this.cuello = cuello;
    }

    public String getPecho() {
        return pecho;
    }

    public void setPecho(String pecho) {
        this.pecho = pecho;
    }

    public String getEspalda() {
        return espalda;
    }

    public void setEspalda(String espalda) {
        this.espalda = espalda;
    }

    public String getABDsuperior() {
        return aBDsuperior;
    }

    public void setABDsuperior(String aBDsuperior) {
        this.aBDsuperior = aBDsuperior;
    }

    public String getABDinferior() {
        return aBDinferior;
    }

    public void setABDinferior(String aBDinferior) {
        this.aBDinferior = aBDinferior;
    }

    public String getGluteo() {
        return gluteo;
    }

    public void setGluteo(String gluteo) {
        this.gluteo = gluteo;
    }

    public String getBrazoI() {
        return brazoI;
    }

    public void setBrazoI(String brazoI) {
        this.brazoI = brazoI;
    }

    public String getBrazoD() {
        return brazoD;
    }

    public void setBrazoD(String brazoD) {
        this.brazoD = brazoD;
    }

    public String getAntebrazoI() {
        return antebrazoI;
    }

    public void setAntebrazoI(String antebrazoI) {
        this.antebrazoI = antebrazoI;
    }

    public String getAntebrazoD() {
        return antebrazoD;
    }

    public void setAntebrazoD(String antebrazoD) {
        this.antebrazoD = antebrazoD;
    }

    public String getMusloI() {
        return musloI;
    }

    public void setMusloI(String musloI) {
        this.musloI = musloI;
    }

    public String getMusloD() {
        return musloD;
    }

    public void setMusloD(String musloD) {
        this.musloD = musloD;
    }

    public String getPantorrilaI() {
        return pantorrilaI;
    }

    public void setPantorrilaI(String pantorrilaI) {
        this.pantorrilaI = pantorrilaI;
    }

    public String getPantorrillaD() {
        return pantorrillaD;
    }

    public void setPantorrillaD(String pantorrillaD) {
        this.pantorrillaD = pantorrillaD;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPorcentajegrasa() {
        return porcentajegrasa;
    }

    public void setPorcentajegrasa(String porcentajegrasa) {
        this.porcentajegrasa = porcentajegrasa;
    }

    public String getPorcentajeagua() {
        return porcentajeagua;
    }

    public void setPorcentajeagua(String porcentajeagua) {
        this.porcentajeagua = porcentajeagua;
    }

    public String getPorcentajemusculo() {
        return porcentajemusculo;
    }

    public void setPorcentajemusculo(String porcentajemusculo) {
        this.porcentajemusculo = porcentajemusculo;
    }

    public String getPorcentajeoseo() {
        return porcentajeoseo;
    }

    public void setPorcentajeoseo(String porcentajeoseo) {
        this.porcentajeoseo = porcentajeoseo;
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
        hash += (numeroValoracion != null ? numeroValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.numeroValoracion == null && other.numeroValoracion != null) || (this.numeroValoracion != null && !this.numeroValoracion.equals(other.numeroValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Valoracion[ numeroValoracion=" + numeroValoracion + " ]";
    }
    
}
