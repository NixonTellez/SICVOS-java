/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.ventas;

import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.controller.exceptions.NonexistentEntityException;
import com.modelo.Detalleventa;
import com.modelo.Ordencompra;
import com.modelo.Producto;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class Ventas implements Serializable{
    
    private int idProd;
    private int cantidad;
    private static List<Producto> listaPr = new ArrayList();
    private String fecha;
    private static List<Ordencompra> listV = new ArrayList();
    private Ordencompra sale = new Ordencompra ();
    private static List<Detalleventa> listDet = new ArrayList();
    private Detalleventa detalle = new Detalleventa();
    private static int totalVenta;
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    public String sales(){
        totalVenta=0;
        listaPr.clear();
        listDet.clear();
        
        listaPr=jpa.findAllEntities("Producto");
        return "sales";
    }
    
    public void agregar(){
        Producto producto = (Producto) jpa.findEntity(idProd , "Producto");
        totalVenta = totalVenta+(cantidad*producto.getValorVenta());
        detalle.setIdProducto(producto);
        detalle.setCantidad(cantidad);
        Ventas.listDet.add(detalle);
    }
    
    public void addVenta(int id) throws NonexistentEntityException, Exception{
        Detalleventa dt;
        Ordencompra uVenta;
        Producto pr;
        int b;
        
        Usuario u = (Usuario) jpa.findEntity(id, "Usuario");
        sale.setIdUsuario(u);
        sale.setFecha(Date.valueOf(fecha));
        sale.setValor(totalVenta);
        
        jpa.create(sale);
        b=jpa.getCount("Ordencompra");
        uVenta =(Ordencompra) jpa.findEntity(b, "Ordencompra");
        
        for (int i = 0; i < listDet.size(); i++) {
            dt=listDet.get(i);
            dt.setNumeroFactura(uVenta);
            jpa.create(dt);
            pr=dt.getIdProducto();
            pr.setCantidad(pr.getCantidad()-dt.getCantidad());
            jpa.edit(pr);
        }
    }
    
    public String hven(){
        listV.clear();
        listV = jpa.findAllEntities("Ordencompra");
        
        return "hven";
    }
    
    
    //Setters y Getters
    
    public List<Producto> getListaPr() {
        return listaPr;
    }

    public void setListaPr(List<Producto> listaPr) {
        Ventas.listaPr = listaPr;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public Ordencompra getSale() {
        return sale;
    }

    public void setSale(Ordencompra sale) {
        this.sale = sale;
    }
    
    public List<Ordencompra> getListV() {
        return listV;
    }

    public void setListV(List<Ordencompra> listV) {
        Ventas.listV = listV;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public List<Detalleventa> getListDet() {
        return listDet;
    }

    public void setListDet(List<Detalleventa> listDet) {
        Ventas.listDet = listDet;
    }

    public Detalleventa getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalleventa detalle) {
        this.detalle = detalle;
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        Ventas.totalVenta = totalVenta;
    }
    
}
