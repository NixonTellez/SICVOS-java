/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author 10 Spring Creators
 */
public abstract class Controller <T> {
    
    public abstract void create(T o);
    public abstract void edit(T o) throws NonexistentEntityException, Exception;
    public abstract void destroy(Integer id) throws NonexistentEntityException;
    public abstract int getCount();
    public abstract T findEntity(Integer id);
    public abstract List<T> findAllEntities();
}
