/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes.controller;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author 10 Spring Creators
 */
public class Config {
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void Conectar() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://db-sicvos.ciim1pf1znkq.us-east-2.rds.amazonaws.com:3306/befree_gym?allowPublicKeyRetrieval=true&useSSL=false&noAccessToProcedureBodies=true","admin","APMsyk6T0fzLroZj2EPd");
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Cerrar() throws Exception{
        try {
            if(cn!=null){
                if(cn.isClosed()== false){
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
