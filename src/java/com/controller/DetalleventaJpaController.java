/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.NonexistentEntityException;
import com.modelo.Detalleventa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Ordencompra;
import com.modelo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 10 Spring Creators
 */
public class DetalleventaJpaController extends Controller<Detalleventa> implements Serializable {

    public DetalleventaJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public DetalleventaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detalleventa detalleventa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordencompra numeroFactura = detalleventa.getNumeroFactura();
            if (numeroFactura != null) {
                numeroFactura = em.getReference(numeroFactura.getClass(), numeroFactura.getNumeroFactura());
                detalleventa.setNumeroFactura(numeroFactura);
            }
            Producto idProducto = detalleventa.getIdProducto();
            if (idProducto != null) {
                idProducto = em.getReference(idProducto.getClass(), idProducto.getIdProducto());
                detalleventa.setIdProducto(idProducto);
            }
            em.persist(detalleventa);
            if (numeroFactura != null) {
                numeroFactura.getDetalleventaCollection().add(detalleventa);
                numeroFactura = em.merge(numeroFactura);
            }
            if (idProducto != null) {
                idProducto.getDetalleventaCollection().add(detalleventa);
                idProducto = em.merge(idProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detalleventa detalleventa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detalleventa persistentDetalleventa = em.find(Detalleventa.class, detalleventa.getNumDetalle());
            Ordencompra numeroFacturaOld = persistentDetalleventa.getNumeroFactura();
            Ordencompra numeroFacturaNew = detalleventa.getNumeroFactura();
            Producto idProductoOld = persistentDetalleventa.getIdProducto();
            Producto idProductoNew = detalleventa.getIdProducto();
            if (numeroFacturaNew != null) {
                numeroFacturaNew = em.getReference(numeroFacturaNew.getClass(), numeroFacturaNew.getNumeroFactura());
                detalleventa.setNumeroFactura(numeroFacturaNew);
            }
            if (idProductoNew != null) {
                idProductoNew = em.getReference(idProductoNew.getClass(), idProductoNew.getIdProducto());
                detalleventa.setIdProducto(idProductoNew);
            }
            detalleventa = em.merge(detalleventa);
            if (numeroFacturaOld != null && !numeroFacturaOld.equals(numeroFacturaNew)) {
                numeroFacturaOld.getDetalleventaCollection().remove(detalleventa);
                numeroFacturaOld = em.merge(numeroFacturaOld);
            }
            if (numeroFacturaNew != null && !numeroFacturaNew.equals(numeroFacturaOld)) {
                numeroFacturaNew.getDetalleventaCollection().add(detalleventa);
                numeroFacturaNew = em.merge(numeroFacturaNew);
            }
            if (idProductoOld != null && !idProductoOld.equals(idProductoNew)) {
                idProductoOld.getDetalleventaCollection().remove(detalleventa);
                idProductoOld = em.merge(idProductoOld);
            }
            if (idProductoNew != null && !idProductoNew.equals(idProductoOld)) {
                idProductoNew.getDetalleventaCollection().add(detalleventa);
                idProductoNew = em.merge(idProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleventa.getNumDetalle();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The detalleventa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detalleventa detalleventa;
            try {
                detalleventa = em.getReference(Detalleventa.class, id);
                detalleventa.getNumDetalle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleventa with id " + id + " no longer exists.", enfe);
            }
            Ordencompra numeroFactura = detalleventa.getNumeroFactura();
            if (numeroFactura != null) {
                numeroFactura.getDetalleventaCollection().remove(detalleventa);
                numeroFactura = em.merge(numeroFactura);
            }
            Producto idProducto = detalleventa.getIdProducto();
            if (idProducto != null) {
                idProducto.getDetalleventaCollection().remove(detalleventa);
                idProducto = em.merge(idProducto);
            }
            em.remove(detalleventa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Detalleventa> findAllEntities() {
        return findDetalleventaEntities(true, -1, -1);
    }

    public List<Detalleventa> findDetalleventaEntities(int maxResults, int firstResult) {
        return findDetalleventaEntities(false, maxResults, firstResult);
    }

    private List<Detalleventa> findDetalleventaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detalleventa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Detalleventa findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detalleventa.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detalleventa> rt = cq.from(Detalleventa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
