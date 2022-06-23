/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public class ControllerFactory implements ControllerFactoryMethod<Object>{

    Controller jpa;
    
    @Override
    public void create(Object o) {
        switch (o.getClass().getSimpleName()){
            case "DetalleVenta":
                jpa = new DetalleventaJpaController();
                jpa.create(o);
                break;
                
            case "Maquina":
                jpa = new MaquinaJpaController();
                jpa.create(o);
                break;
            
            case "Membresia":
                jpa = new MembresiaJpaController();
                jpa.create(o);
                break;
            
            case "Novedad":
                jpa = new NovedadJpaController();
                jpa.create(o);
                break;
            
            case "Ordencompra":
                jpa = new OrdencompraJpaController();
                jpa.create(o);
                break;
                
            case "Pqrs":
                jpa = new PqrsJpaController();
                jpa.create(o);
                break;
            
            case "Producto":
                jpa = new ProductoJpaController();
                jpa.create(o);
                break;
            
            case "Rutina":
                jpa = new RutinaJpaController();
                jpa.create(o);
                break;
            
            case "Usuario":
                jpa = new UsuarioJpaController();
                jpa.create(o);
                break;
                
            case "Valoracion":
                jpa = new ValoracionJpaController();
                jpa.create(o);
                break;
        }
    }

    @Override
    public void edit(Object o) {
        try {
            switch (o.getClass().getSimpleName()){
                case "DetalleVenta":
                    jpa = new DetalleventaJpaController();
                    jpa.edit(o);
                    break;

                case "Maquina":
                    jpa = new MaquinaJpaController();
                    jpa.edit(o);
                    break;

                case "Membresia":
                    jpa = new MembresiaJpaController();
                    jpa.edit(o);
                    break;

                case "Novedad":
                    jpa = new NovedadJpaController();
                    jpa.edit(o);
                    break;

                case "Ordencompra":
                    jpa = new OrdencompraJpaController();
                    jpa.edit(o);
                    break;

                case "Pqrs":
                    jpa = new PqrsJpaController();
                    jpa.edit(o);
                    break;

                case "Producto":
                    jpa = new ProductoJpaController();
                    jpa.edit(o);
                    break;

                case "Rutina":
                    jpa = new RutinaJpaController();
                    jpa.edit(o);
                    break;

                case "Usuario":
                    jpa = new UsuarioJpaController();
                    jpa.edit(o);
                    break;

                case "Valoracion":
                    jpa = new ValoracionJpaController();
                    jpa.edit(o);
                    break;
            }
        } catch (Exception e) {
        }
        
    }

    @Override
    public void destroy(Integer id, String clase) {
        try {
            switch (clase){
                case "DetalleVenta":
                    jpa = new DetalleventaJpaController();
                    jpa.destroy(id);
                    break;

                case "Maquina":
                    jpa = new MaquinaJpaController();
                    jpa.destroy(id);
                    break;

                case "Membresia":
                    jpa = new MembresiaJpaController();
                    jpa.destroy(id);
                    break;

                case "Novedad":
                    jpa = new NovedadJpaController();
                    jpa.destroy(id);
                    break;

                case "Ordencompra":
                    jpa = new OrdencompraJpaController();
                    jpa.destroy(id);
                    break;

                case "Pqrs":
                    jpa = new PqrsJpaController();
                    jpa.destroy(id);
                    break;

                case "Producto":
                    jpa = new ProductoJpaController();
                    jpa.destroy(id);
                    break;

                case "Rutina":
                    jpa = new RutinaJpaController();
                    jpa.destroy(id);
                    break;

                case "Usuario":
                    jpa = new UsuarioJpaController();
                    jpa.destroy(id);
                    break;

                case "Valoracion":
                    jpa = new ValoracionJpaController();
                    jpa.edit(id);
                    break;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public int getCount(String clase) {
        int cuenta = 0;
        switch (clase){
            case "DetalleVenta":
                jpa = new DetalleventaJpaController();
                cuenta = jpa.getCount();
                break;

            case "Maquina":
                jpa = new MaquinaJpaController();
                cuenta = jpa.getCount();
                break;

            case "Membresia":
                jpa = new MembresiaJpaController();
                cuenta = jpa.getCount();
                break;

            case "Novedad":
                jpa = new NovedadJpaController();
                cuenta = jpa.getCount();
                break;

            case "Ordencompra":
                jpa = new OrdencompraJpaController();
                cuenta = jpa.getCount();
                break;

            case "Pqrs":
                jpa = new PqrsJpaController();
                cuenta = jpa.getCount();
                break;

            case "Producto":
                jpa = new ProductoJpaController();
                cuenta = jpa.getCount();
                break;

            case "Rutina":
                jpa = new RutinaJpaController();
                cuenta = jpa.getCount();
                break;

            case "Usuario":
                jpa = new UsuarioJpaController();
                cuenta = jpa.getCount();
                break;

            case "Valoracion":
                jpa = new ValoracionJpaController();
                cuenta = jpa.getCount();
                break;
        }
        return cuenta;
    }

    @Override
    public Object findEntity(Integer id, String clase) {
        Object o = new Object();
        switch (clase){
            case "DetalleVenta":
                jpa = new DetalleventaJpaController();
                o = jpa.findEntity(id);
                break;

            case "Maquina":
                jpa = new MaquinaJpaController();
                o = jpa.findEntity(id);
                break;

            case "Membresia":
                jpa = new MembresiaJpaController();
                o = jpa.findEntity(id);
                break;

            case "Novedad":
                jpa = new NovedadJpaController();
                o = jpa.findEntity(id);
                break;

            case "Ordencompra":
                jpa = new OrdencompraJpaController();
                o = jpa.findEntity(id);
                break;

            case "Pqrs":
                jpa = new PqrsJpaController();
                o = jpa.findEntity(id);
                break;

            case "Producto":
                jpa = new ProductoJpaController();
                o = jpa.findEntity(id);
                break;

            case "Rutina":
                jpa = new RutinaJpaController();
                o = jpa.findEntity(id);
                break;

            case "Usuario":
                jpa = new UsuarioJpaController();
                o = jpa.findEntity(id);
                break;

            case "Valoracion":
                jpa = new ValoracionJpaController();
                o = jpa.findEntity(id);
                break;
        }
        return o;
    }

    @Override
    public List<Object> findAllEntities(String clase) {
        List<Object> lista = new ArrayList();
        switch (clase){
            case "DetalleVenta":
                jpa = new DetalleventaJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Maquina":
                jpa = new MaquinaJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Membresia":
                jpa = new MembresiaJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Novedad":
                jpa = new NovedadJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Ordencompra":
                jpa = new OrdencompraJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Pqrs":
                jpa = new PqrsJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Producto":
                jpa = new ProductoJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Rutina":
                jpa = new RutinaJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Usuario":
                jpa = new UsuarioJpaController();
                lista = jpa.findAllEntities();
                break;

            case "Valoracion":
                jpa = new ValoracionJpaController();
                lista = jpa.findAllEntities();
                break;
        }
        return lista;
    }

    
}
