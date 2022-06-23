/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.usuarios;

import com.bean.facade.UsuarioBean;
import com.reportes.controller.ReporteMembresiaController;
import com.reportes.controller.ReporteProductosController;
import com.reportes.controller.ReporteVentasController;
import com.reportes.modelo.ReporteMembresia;
import com.reportes.modelo.ReporteProductos;
import com.reportes.modelo.ReporteVentas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 10 Spring Creators
 */
public class Reportes implements Serializable{
    
    private static List<ReporteMembresia> rMembresia = new ArrayList();
    private static List<ReporteVentas> listV = new ArrayList();
    private static List<ReporteProductos> rProductos = new ArrayList();
    
    public String reports(){
        ReporteMembresiaController rmc = new ReporteMembresiaController(); 
        ReporteVentasController rvc = new ReporteVentasController(); 
        ReporteProductosController rpc = new ReporteProductosController();
        try {
            rMembresia = rmc.listar();
            listV = rvc.listar();
            rProductos = rpc.listar();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "reports";
    }
    
    //Getters y Setters
    
    public List<ReporteMembresia> getrMembresia() {
        return rMembresia;
    }

    public void setrMembresia(List<ReporteMembresia> rMembresia) {
        Reportes.rMembresia = rMembresia;
    }

    public List<ReporteVentas> getListV() {
        return listV;
    }

    public void setListV(List<ReporteVentas> listV) {
        Reportes.listV = listV;
    }

    public List<ReporteProductos> getrProductos() {
        return rProductos;
    }

    public void setrProductos(List<ReporteProductos> rProductos) {
        this.rProductos = rProductos;
    }

}
