/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.facade;

import com.bean.servicios.MembresiaBean;
import com.bean.servicios.Navegacion;
import com.bean.servicios.PQRSBean;
import com.bean.servicios.RutinaBean;
import com.bean.servicios.ValoracionBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 10 Spring Creators
 */
@ManagedBean (name = "service")
@RequestScoped
public class ServicioBean implements Serializable{
    
    MembresiaBean mem = new MembresiaBean();
    PQRSBean pqrs = new PQRSBean();
    RutinaBean rutina = new RutinaBean();
    ValoracionBean valo = new ValoracionBean();
    Navegacion nav = new Navegacion();
    
    
    //Setters y Getters

    
    public MembresiaBean getMem() {
        return mem;
    }

    public void setMem(MembresiaBean mem) {
        this.mem = mem;
    }

    public PQRSBean getPqrs() {
        return pqrs;
    }

    public void setPqrs(PQRSBean pqrs) {
        this.pqrs = pqrs;
    }

    public RutinaBean getRutina() {
        return rutina;
    }

    public void setRutina(RutinaBean rutina) {
        this.rutina = rutina;
    }

    public ValoracionBean getValo() {
        return valo;
    }

    public void setValo(ValoracionBean valo) {
        this.valo = valo;
    }

    public Navegacion getNav() {
        return nav;
    }

    public void setNav(Navegacion nav) {
        this.nav = nav;
    }
    
}
