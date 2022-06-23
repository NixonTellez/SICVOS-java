/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.servicios;

import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.modelo.Pqrs;
import com.modelo.Usuario;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class PQRSBean implements Serializable{
    
    private String fecha;
    private static List<Pqrs> listaPqrs = new ArrayList();
    private Pqrs cliente = new Pqrs();
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    //Este metodo consulta el listado de PQRSBean en la base de datos para el reporte
    public String rpqrs(){
        listaPqrs = jpa.findAllEntities("Pqrs");
        
        return "rpqrs";
    }
    
    //Agrega los PQRSBean a la base de datos de manera anonima, por usuarios sin cuenta
    public void addPQRS1(int i){
        Usuario u;
        
        switch(i){
            case 1:
                cliente.setTipo("PREGUNTA");
                break;
            case 2:
                cliente.setTipo("QUEJA");
                break;
            case 3:
                cliente.setTipo("RECLAMO");
                break;
            case 4:
                cliente.setTipo("SUGERENCIA");
                break;
        }
        cliente.setFecha(Date.valueOf(fecha));
        u = (Usuario) jpa.findEntity(1111, "Usuario");
        cliente.setIdUsuario(u);
        jpa.create(cliente);
    }
    
    //Agrega los PQRSBean a la base de datos de usuarios con cuenta
    public void addPQRS2(int i, int id){
        Usuario u;
        
        switch(i){
            case 1:
                cliente.setTipo("PREGUNTA");
                break;
            case 2:
                cliente.setTipo("QUEJA");
                break;
            case 3:
                cliente.setTipo("RECLAMO");
                break;
            case 4:
                cliente.setTipo("SUGERENCIA");
                break;
        }
        cliente.setFecha(Date.valueOf(fecha));
        u = (Usuario) jpa.findEntity(id, "Usuario");
        cliente.setIdUsuario(u);
        jpa.create(cliente);
    }
    
    //Setter y Getters
    
    public Pqrs getCliente() {
        return cliente;
    }

    public void setCliente(Pqrs cliente) {
        this.cliente = cliente;
    }
    
    public List<Pqrs> getListaPqrs() {
        return listaPqrs;
    }

    public void setListaPqrs(List<Pqrs> listaPqrs) {
        PQRSBean.listaPqrs = listaPqrs;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
