/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.facade;

import com.bean.inventarios.MaquinariaBean;
import com.bean.inventarios.Navegacion;
import com.bean.inventarios.ProductoBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author 10 Spring Creators
 */
@ManagedBean (name = "inventory")
@RequestScoped
public class InventarioBean implements Serializable{
    
    MaquinariaBean machi = new MaquinariaBean();
    ProductoBean stock = new ProductoBean();
    Navegacion nav = new Navegacion();
    
    
    //Aqui inician los getters y setters de los objetos declarados
    

    public MaquinariaBean getMachi() {
        return machi;
    }

    public void setMachi(MaquinariaBean machi) {
        this.machi = machi;
    }

    public ProductoBean getStock() {
        return stock;
    }

    public void setStock(ProductoBean stock) {
        this.stock = stock;
    }

    public Navegacion getNav() {
        return nav;
    }

    public void setNav(Navegacion nav) {
        this.nav = nav;
    }
    
    

    
}
