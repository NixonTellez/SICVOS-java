/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.servicios;

import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.controller.MembresiaJpaController;
import com.modelo.Usuario;
import com.modelo.Membresia;
import com.modelo.Rutina;
import com.reportes.controller.MembresiaValida;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 10 Spring Creators
 */
public class RutinaBean implements Serializable{
    
    private Membresia memb = new Membresia();
    private Rutina rutina;
    private static int rutd;
    private int cantidad;
    private String ejercicio;
    private String descripcion;
    private String ejercicio2;
    private String descripcion2;
    private String ejercicio3;
    private String descripcion3;
    private String ejercicio4;
    private String descripcion4;
    private String ejercicio5;
    private String descripcion5;
    private String ejercicio6;
    private String descripcion6;
    private String ejercicio7;
    private String descripcion7;
    private String ejercicio8;
    private String descripcion8;
    private String ejercicio9;
    private String descripcion9;
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    
    //Metodo para consultar la rutina
    public String cservices(int id) {
        MembresiaJpaController mjpa = new MembresiaJpaController();
        MembresiaValida d = new MembresiaValida();
        try {
            Usuario u=(Usuario) jpa.findEntity(id, "Usuario");
            cantidad=d.listar(id)+1;
            memb=mjpa.validarMembresia(u);
            if(cantidad<=memb.getDiasRestantes().getDia()){
                rutina= (Rutina) jpa.findEntity(cantidad, "Rutina");
            }else{
                rutina= (Rutina) jpa.findEntity(404, "Rutina");
            }
        } catch (Exception e) {
        }
        return "servicios";
    }
    
    public void consultRutina(){
        rutd=cantidad;
        rutina= (Rutina) jpa.findEntity(cantidad, "Rutina");
    }
    
    public void editRutina(int i){
        try {
            rutina =  (Rutina) jpa.findEntity(rutd, "Rutina");
            switch(i){
                case 1:
                    rutina.setEjercicio1(ejercicio);
                    rutina.setDescripciónE1(descripcion);
                    jpa.edit(rutina);
                    break;
                
                case 2:
                    rutina.setEjercicio2(ejercicio2);
                    rutina.setDescripciónE2(descripcion2);
                    jpa.edit(rutina);
                    break;
                    
                case 3:
                    rutina.setEjercicio3(ejercicio3);
                    rutina.setDescripciónE3(descripcion3);
                    jpa.edit(rutina);
                    break;
                    
                case 4:
                    rutina.setEjercicio4(ejercicio4);
                    rutina.setDescripciónE4(descripcion4);
                    jpa.edit(rutina);
                    break;
                
                case 5:
                    rutina.setEjercicio5(ejercicio5);
                    rutina.setDescripciónE5(descripcion5);
                    jpa.edit(rutina);
                    break;
                    
                case 6:
                    rutina.setEjercicio6(ejercicio6);
                    rutina.setDescripciónE6(descripcion6);
                    jpa.edit(rutina);
                    break;
                
                case 7:
                    rutina.setEjercicio7(ejercicio7);
                    rutina.setDescripciónE7(descripcion7);
                    jpa.edit(rutina);
                    break;
                
                case 8:
                    rutina.setEjercicio8(ejercicio8);
                    rutina.setDescripciónE8(descripcion8);
                    jpa.edit(rutina);
                    break;
                    
                case 9:
                    rutina.setEjercicio9(ejercicio9);
                    rutina.setDescripciónE9(descripcion9);
                    jpa.edit(rutina);
                    break;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(RutinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Setter y Getters
    
    
    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEjercicio2() {
        return ejercicio2;
    }

    public void setEjercicio2(String ejercicio2) {
        this.ejercicio2 = ejercicio2;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public String getEjercicio3() {
        return ejercicio3;
    }

    public void setEjercicio3(String ejercicio3) {
        this.ejercicio3 = ejercicio3;
    }

    public String getDescripcion3() {
        return descripcion3;
    }

    public void setDescripcion3(String descripcion3) {
        this.descripcion3 = descripcion3;
    }

    public String getEjercicio4() {
        return ejercicio4;
    }

    public void setEjercicio4(String ejercicio4) {
        this.ejercicio4 = ejercicio4;
    }

    public String getDescripcion4() {
        return descripcion4;
    }

    public void setDescripcion4(String descripcion4) {
        this.descripcion4 = descripcion4;
    }

    public String getEjercicio5() {
        return ejercicio5;
    }

    public void setEjercicio5(String ejercicio5) {
        this.ejercicio5 = ejercicio5;
    }

    public String getDescripcion5() {
        return descripcion5;
    }

    public void setDescripcion5(String descripcion5) {
        this.descripcion5 = descripcion5;
    }

    public String getEjercicio6() {
        return ejercicio6;
    }

    public void setEjercicio6(String ejercicio6) {
        this.ejercicio6 = ejercicio6;
    }

    public String getDescripcion6() {
        return descripcion6;
    }

    public void setDescripcion6(String descripcion6) {
        this.descripcion6 = descripcion6;
    }

    public String getEjercicio7() {
        return ejercicio7;
    }

    public void setEjercicio7(String ejercicio7) {
        this.ejercicio7 = ejercicio7;
    }

    public String getDescripcion7() {
        return descripcion7;
    }

    public void setDescripcion7(String descripcion7) {
        this.descripcion7 = descripcion7;
    }

    public String getEjercicio8() {
        return ejercicio8;
    }

    public void setEjercicio8(String ejercicio8) {
        this.ejercicio8 = ejercicio8;
    }

    public String getDescripcion8() {
        return descripcion8;
    }

    public void setDescripcion8(String descripcion8) {
        this.descripcion8 = descripcion8;
    }

    public String getEjercicio9() {
        return ejercicio9;
    }

    public void setEjercicio9(String ejercicio9) {
        this.ejercicio9 = ejercicio9;
    }

    public String getDescripcion9() {
        return descripcion9;
    }

    public void setDescripcion9(String descripcion9) {
        this.descripcion9 = descripcion9;
    }
    
    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
    
    public int getRutd() {
        return rutd;
    }

    public void setRutd(int rutd) {
        RutinaBean.rutd = rutd;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
