/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.facade;

import com.bean.usuarios.NavegacionUsuario;
import com.bean.usuarios.Reportes;
import com.bean.usuarios.UsuarioSicvos;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 10 Spring Creators
 */
@ManagedBean (name = "user")
@SessionScoped
public class UsuarioBean implements Serializable{
    
    UsuarioSicvos user = new UsuarioSicvos();
    NavegacionUsuario navU = new NavegacionUsuario();
    Reportes report = new Reportes();
    
    //Getters y setters

    public UsuarioSicvos getUser() {
        return user;
    }

    public void setUser(UsuarioSicvos user) {
        this.user = user;
    }

    public NavegacionUsuario getNavU() {
        return navU;
    }

    public void setNavU(NavegacionUsuario navU) {
        this.navU = navU;
    }

    public Reportes getReport() {
        return report;
    }

    public void setReport(Reportes report) {
        this.report = report;
    }
    
    
}
