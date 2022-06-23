/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.servicios;

import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.controller.MembresiaJpaController;
import com.modelo.Membresia;
import com.modelo.Rutina;
import com.modelo.Usuario;
import com.reportes.controller.MembresiaValida;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class MembresiaBean implements Serializable{
    
    private int idClient;
    private int cantidad; 
    private String fecha;
    private static List<Membresia> totalMem = new ArrayList();
    private Membresia memb = new Membresia();
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    
    //Metodo para consultar la membresia del cliente
    public String mensualidad(int id) {
        MembresiaJpaController mjpa = new MembresiaJpaController();
        MembresiaValida d = new MembresiaValida();
        try {
            Usuario u=(Usuario) jpa.findEntity(id, "Usuario");
            memb=mjpa.validarMembresia(u);
            cantidad=d.listar(id)+1;
            if(cantidad<=memb.getDiasRestantes().getDia()){
                cantidad=memb.getDiasRestantes().getDia()-cantidad;
                fecha=(cantidad+" días restantes");
            }else{
                fecha=("Caducó hace "+cantidad+" días");
            }
        } catch (Exception e) {
        }
        
        return "mens";
    }
    
    //Metodo para listar las membresias
    public String membre() {
        totalMem.clear();
        totalMem = jpa.findAllEntities("Membresia");
        return "membre";
    }
    
    //Metodo para agregar nuevas membresias
    public void addMembresia(){
        
        try {
           
            memb.setIdUsuario((Usuario) jpa.findEntity(idClient, "Usuario"));
            memb.setFechaInicio(Date.valueOf(fecha));
            switch(memb.getTipoPlan()){
                case "QUINCENAL":
                    memb.setValorPlan(30000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(15, "Rutina"));
                    break;
                case "MENSUAL":
                    memb.setValorPlan(60000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(30, "Rutina"));
                    break;
                case "TRIMESTRAL":
                    memb.setValorPlan(180000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(90, "Rutina"));
                    break;
                case "SEMESTRAL":
                    memb.setValorPlan(360000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(181, "Rutina"));
                    break;
                case "ANUAL":
                    memb.setValorPlan(720000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(365, "Rutina"));
                    break;
            }
            jpa.create(memb);
        } catch (Exception e) {
        }
    }
    
    //Metodo para consultar una membresia en especifico
    public void consulMembresia(){
        MembresiaJpaController mjpa = new MembresiaJpaController();
        Usuario u;
        try {
            u = (Usuario) jpa.findEntity(idClient, "Usuario");
            memb=mjpa.validarMembresia(u);
            totalMem.clear();
            totalMem.add(memb);
        } catch (Exception e) {
        }
    }
    
    public void membresiaUpdate(Membresia temporal) throws Exception{
        if(temporal != null){
            this.memb=temporal;
            idClient = memb.getIdUsuario().getIdUsuario() ;
        }
    }
    
    public void editMembresia() throws Exception{
        
        memb.setIdUsuario((Usuario) jpa.findEntity(idClient, "Usuario"));
        memb.setFechaInicio(Date.valueOf(fecha));
            switch(memb.getTipoPlan()){
                case "QUINCENAL ":
                    memb.setValorPlan(30000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(15, "Rutina"));
                    break;
                case "MENSUAL":
                    memb.setValorPlan(60000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(30, "Rutina"));
                    break;
                case "TRIMESTRAL":
                    memb.setValorPlan(180000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(90, "Rutina"));
                    break;
                case "SEMESTRAL":
                    memb.setValorPlan(360000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(181, "Rutina"));
                    break;
                case "ANUAL":
                    memb.setValorPlan(720000);
                    memb.setDiasRestantes((Rutina) jpa.findEntity(365, "Rutina"));
                    break;
            }
        jpa.edit(memb);
        this.consulMembresia();
    }
    
    
    // Getters y Setters de los diferentes atributos usados en el modulo
    
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public List<Membresia> getTotalMem() {
        return totalMem;
    }

    public void setTotalMem(List<Membresia> totalMem) {
        MembresiaBean.totalMem = totalMem;
    }

    public Membresia getMemb() {
        return memb;
    }

    public void setMemb(Membresia memb) {
        this.memb = memb;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
