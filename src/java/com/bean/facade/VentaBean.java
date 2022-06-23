/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.facade;

import com.bean.ventas.Ventas;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author 10 Spring Creators
 */
@ManagedBean (name = "sale")
@RequestScoped
public class VentaBean implements Serializable{
    
    Ventas buy = new Ventas();
    
    
    //Stters y Getters

    
    public Ventas getBuy() {
        return buy;
    }

    public void setBuy(Ventas buy) {
        this.buy = buy;
    }

}
