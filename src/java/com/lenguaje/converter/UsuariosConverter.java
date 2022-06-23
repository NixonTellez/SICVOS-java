/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenguaje.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author 10 Spring Creators
 */
@FacesConverter("userEnglish")
public class UsuariosConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String english = "";
        if (o != null){
            english = (String) o;
            switch(english){
                case("CLIENTE"):
                    english = "CLIENT";
                    break;
                
                case("ENTRENADOR"):
                    english = "TRAINER";
                    break;
                    
                case("ADMINISTRADOR"):
                    english = "MANAGER";
                    break;
            }
        }
        
        return english;
    }
    
}
