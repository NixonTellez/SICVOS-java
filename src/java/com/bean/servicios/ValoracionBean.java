/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.servicios;

import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.controller.ValoracionJpaController;
import com.modelo.Usuario;
import com.modelo.Valoracion;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class ValoracionBean implements Serializable{
    
    private int idClient;
    private String fecha;
    private static List<Valoracion> valsClient = new ArrayList();
    private Valoracion valuate = new Valoracion();
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    //Metodo para consultar la valoración del cliente
    public String valoration(int id){
        ValoracionJpaController vjpa = new ValoracionJpaController();
        Usuario u=(Usuario) jpa.findEntity(id, "Usuario");
        valsClient.clear();
        valsClient=vjpa.userValoraciones(u);
        
        return "valor";
    }
    
    //Metodo para agregar una nueva valoración
    public String addValora(){
        Usuario u=(Usuario) jpa.findEntity(idClient, "Usuario");
        valuate.setIdUsuario(u);
        valuate.setFecha(Date.valueOf(fecha));
        jpa.create(valuate);
        
        return "valoracion";
    }
    
    
    //Setters y Getters
    
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public List<Valoracion> getValsClient() {
        return valsClient;
    }

    public void setValsClient(List<Valoracion> valsClient) {
        ValoracionBean.valsClient = valsClient;
    }

    public Valoracion getValuate() {
        return valuate;
    }

    public void setValuate(Valoracion valuate) {
        this.valuate = valuate;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
