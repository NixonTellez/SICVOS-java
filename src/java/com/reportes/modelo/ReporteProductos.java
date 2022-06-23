/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes.modelo;

/**
 *
 * @author 10 Spring Creators
 */
public class ReporteProductos {
    
    private String nombre;
    private int valorVenta;
    private int valorCompra;
    private int catidadVendida;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }

    public int getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getCatidadVendida() {
        return catidadVendida;
    }

    public void setCatidadVendida(int catidadVendida) {
        this.catidadVendida = catidadVendida;
    }
    
}
