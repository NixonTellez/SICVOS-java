/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.modelo.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 10 Spring Creators
 */
@Named
@ViewScoped
public class sesionController implements Serializable{
    
    public void VerificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("BefreeUser");
            if(user==null){
                context.getExternalContext().redirect("./../index.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
