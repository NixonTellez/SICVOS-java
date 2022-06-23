/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes.controller;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 10 Spring Creators
 */
public class MembresiaValida extends Config implements Serializable {
    ResultSet rs;
    public int listar(int u) throws Exception{
        
        int diasPasados=0;
        
        try {
            
            this.Conectar();
            String sql=("select timestampdiff(DAY, m.fecha_inicio, current_date()) as dias from membresia as m where m.idUsuario="+u);
            Statement st = this.getCn().createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                diasPasados=rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return diasPasados;
    }
}
