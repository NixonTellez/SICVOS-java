/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public interface ControllerFactoryMethod <T> {
    
    public abstract void create(T o);
    public abstract void edit(T o);
    public abstract void destroy(Integer id, String clase);
    public abstract int getCount(String clase);
    public abstract T findEntity(Integer id, String clase);
    public abstract List<T> findAllEntities(String clase);
}
