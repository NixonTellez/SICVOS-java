/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes.controller;

import com.reportes.modelo.ReporteMembresia;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class ReporteMembresiaController extends Config implements Serializable{
    ResultSet rs;
    
    public List<ReporteMembresia> listar() throws Exception{
        
        List<ReporteMembresia> lista;
        
        try {
            
            this.Conectar();
            CallableStatement st = this.getCn().prepareCall("{CALL reporteMembresias}");
            rs=st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                ReporteMembresia rm=new ReporteMembresia();
                rm.setCantidad(rs.getInt(2));
                rm.setTipoPlan(rs.getString(1));
                lista.add(rm);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
}
