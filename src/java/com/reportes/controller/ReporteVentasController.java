/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes.controller;

import com.modelo.Usuario;
import com.reportes.modelo.ReporteVentas;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class ReporteVentasController extends Config implements Serializable{
    
    ResultSet rs;
    
    public List<ReporteVentas> listar() throws Exception{
        
        List<ReporteVentas> lista;
        
        try {
            
            this.Conectar();
            CallableStatement st = this.getCn().prepareCall("{CALL reporteVentas}");
            rs=st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                ReporteVentas rm=new ReporteVentas();
                rm.setNumeroFactura(rs.getInt(1));
                rm.setIdUsuario(rs.getInt(2));
                rm.setFecha(rs.getDate(3));
                rm.setValor(rs.getInt(4));
                rm.setTipoPago(rs.getString(5));
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
