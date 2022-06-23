/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.IllegalOrphanException;
import com.controller.exceptions.NonexistentEntityException;
import com.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Detalleventa;
import com.modelo.Producto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 10 Spring Creators
 */
public class ProductoJpaController extends Controller<Producto> implements Serializable {

    public ProductoJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
                if (producto.getDetalleventaCollection() == null) {
            producto.setDetalleventaCollection(new ArrayList<Detalleventa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Detalleventa> attachedDetalleventaCollection = new ArrayList<Detalleventa>();
            for (Detalleventa detalleventaCollectionDetalleventaToAttach : producto.getDetalleventaCollection()) {
                detalleventaCollectionDetalleventaToAttach = em.getReference(detalleventaCollectionDetalleventaToAttach.getClass(), detalleventaCollectionDetalleventaToAttach.getNumDetalle());
                attachedDetalleventaCollection.add(detalleventaCollectionDetalleventaToAttach);
            }
            producto.setDetalleventaCollection(attachedDetalleventaCollection);
            em.persist(producto);
            for (Detalleventa detalleventaCollectionDetalleventa : producto.getDetalleventaCollection()) {
                Producto oldIdProductoOfDetalleventaCollectionDetalleventa = detalleventaCollectionDetalleventa.getIdProducto();
                detalleventaCollectionDetalleventa.setIdProducto(producto);
                detalleventaCollectionDetalleventa = em.merge(detalleventaCollectionDetalleventa);
                if (oldIdProductoOfDetalleventaCollectionDetalleventa != null) {
                    oldIdProductoOfDetalleventaCollectionDetalleventa.getDetalleventaCollection().remove(detalleventaCollectionDetalleventa);
                    oldIdProductoOfDetalleventaCollectionDetalleventa = em.merge(oldIdProductoOfDetalleventaCollectionDetalleventa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntity(producto.getIdProducto()) != null) {
                try {
                    throw new PreexistingEntityException("Producto " + producto + " already exists.", ex);
                } catch (PreexistingEntityException ex1) {
                    Logger.getLogger(ProductoJpaController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Collection<Detalleventa> detalleventaCollectionOld = persistentProducto.getDetalleventaCollection();
            Collection<Detalleventa> detalleventaCollectionNew = producto.getDetalleventaCollection();
            List<String> illegalOrphanMessages = null;
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            producto = em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws  NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findAllEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
}
