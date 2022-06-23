/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.inventarios;

import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.controller.exceptions.IllegalOrphanException;
import com.modelo.Maquina;
import com.modelo.Novedad;
import com.modelo.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author 10 Spring Creators
 */
public class MaquinariaBean implements Serializable{
    
    private static List<Maquina> listMaq = new ArrayList();
    private Maquina maquina = new Maquina();
    private static List<Novedad> novedades = new ArrayList();
    private Novedad novedad = new Novedad();
    private int idMaq;
    private Part file;
    private String fecha;
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    public String rmaq(){
        novedades = jpa.findAllEntities("Novedad");
        
        return "rmaq";
    }
    
    public String hmaq(){
        
        novedades.clear();
        novedades = jpa.findAllEntities("Novedad");
        
        return "hmaq";
    }
    
    public String deleteMaq() throws IllegalOrphanException{
        
        jpa.destroy(idMaq, "Maquina");
        listMaq.clear();
        listMaq= jpa.findAllEntities("Maquina");
        
        return "maqui";
    }
    
    public String addNov(int id) {
        
        novedad.setFecha(Date.valueOf(fecha));
        Usuario u=(Usuario) jpa.findEntity(id, "Usuario");
        novedad.setIdUsuario(u);
        maquina = (Maquina)jpa.findEntity(idMaq, "Maquina");
        novedad.setIdMaquina(maquina);
        jpa.create(novedad);
        listMaq.clear();
        
        listMaq= jpa.findAllEntities("Maquina");
        
        return "maqui";
    }
    
    public String addMaq(){
        try {
            maquina.setEstado("EN USO");
            jpa.create(maquina);
        } catch (Exception ex) {
            Logger.getLogger(MaquinariaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listMaq.clear();
        listMaq= jpa.findAllEntities("Maquina");
        
        return "maqui";
    }
    
    public String maqui(){
        
        listMaq.clear();
        listMaq= jpa.findAllEntities("Maquina");
        
        return "maqui";
    }
    
    public String guardarTxt() throws IOException{
      if (null != file) {
        InputStreamReader reader = new InputStreamReader(this.file.getInputStream());
        BufferedReader br = new BufferedReader(reader);
        String line;
        int o=1;
        
        while ((line = br.readLine())!=null){
            System.out.println(line);
            StringTokenizer st = new StringTokenizer(line, ",");
            while (st.hasMoreTokens()){
                switch(o){
                    case 1:
                        maquina.setIdMaquina(Integer.parseInt(st.nextToken()));
                        o++;
                        break;
                    case 2:
                        maquina.setNombre(st.nextToken());
                        o++;
                        break;
                    case 3:
                        maquina.setEstado(st.nextToken());
                        o=1;
                        jpa.create(maquina);
                        break;
                    }
                }
            }
            listMaq.clear();
            listMaq= jpa.findAllEntities("Maquina");
            return "maqui";
        }else{
            return "";
      }
      
    }
    
    //Getters y Setters
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        MaquinariaBean.novedades = novedades;
    }
    
    public List<Maquina> getListMaq() {
        return listMaq;
    }

    public void setListMaq(List<Maquina> listMaq) {
        MaquinariaBean.listMaq = listMaq;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public int getIdMaq() {
        return idMaq;
    }

    public void setIdMaq(int idMaq) {
        this.idMaq = idMaq;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
}
