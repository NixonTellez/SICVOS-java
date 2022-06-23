/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.inventarios;

import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.controller.exceptions.IllegalOrphanException;
import com.controller.exceptions.NonexistentEntityException;
import com.modelo.Producto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
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
public class ProductoBean implements Serializable{
    
    private int idProd;
    private int cantidad;
    private Part file;
    private static List<Producto> listaPr = new ArrayList();
    private Producto producto = new Producto();
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    public String inventory(){
        listaPr.clear();
        
        listaPr = jpa.findAllEntities("Producto");
        
        return "inventory";
    }
    
    public String deleteStock() throws IllegalOrphanException{
        jpa.destroy(idProd, "Producto");
        listaPr.clear();
        listaPr = jpa.findAllEntities("Producto");
        
        return "inventory";
    }
    
    public String prodAdd(){
        listaPr.clear();
        listaPr = jpa.findAllEntities("Producto");
        return "prodAdd";
    }
    
    public String mercAdd() throws NonexistentEntityException, Exception{
        producto =(Producto) jpa.findEntity(idProd, "Producto");
        
        cantidad=cantidad+producto.getCantidad();
        producto.setCantidad(cantidad);
        
        jpa.edit(producto);
        
        listaPr.clear();
        listaPr = jpa.findAllEntities("Producto");
        
        return "inventory";
    }
    
    public String editStock() throws NonexistentEntityException, Exception {
        
        jpa.edit(producto);
        listaPr.clear();
        listaPr = jpa.findAllEntities("Producto");
        
        return "inventory";
    }
    
    public String regProd() throws Exception{
        
        jpa.create(producto);
        listaPr.clear();
        listaPr = jpa.findAllEntities("Producto");
        
        return "inventory";
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
                        producto.setIdProducto(Integer.parseInt(st.nextToken()));
                        o++;
                        break;
                    case 2:
                        producto.setNombre(st.nextToken());
                        o++;
                        break;
                    case 3:
                        producto.setCantidad(Integer.parseInt(st.nextToken()));
                        o++;
                        break;
                    case 4:
                        producto.setValorCompra(Integer.parseInt(st.nextToken()));
                        o++;
                        break;
                    case 5:
                        producto.setValorVenta(Integer.parseInt(st.nextToken()));
                        o=1;
                        jpa.create(producto);
                        break;
                    }
                }
            }
            listaPr.clear();
            listaPr= jpa.findAllEntities("Producto");
            return "inventory";
        }else{
            return "";
      }
      
    }
    
    
    //Setters y Getters
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public List<Producto> getListaPr() {
        return listaPr;
    }

    public void setListaPr(List<Producto> listaPr) {
        ProductoBean.listaPr = listaPr;
    }
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
