/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes.controller;

import com.reportes.modelo.ReporteProductos;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class ReporteProductosController extends Config implements Serializable{
    
    ResultSet rs;
    
    public List<ReporteProductos> listar() throws Exception{
        
        List<ReporteProductos> lista;
        
        try {
            
            this.Conectar();
            CallableStatement st = this.getCn().prepareCall("{CALL reporteProductos}");
            rs=st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                ReporteProductos rm=new ReporteProductos();
                rm.setNombre(rs.getString(1));
                rm.setValorCompra(rs.getInt(3));
                rm.setValorVenta(rs.getInt(2));
                rm.setCatidadVendida(rs.getInt(4));
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
