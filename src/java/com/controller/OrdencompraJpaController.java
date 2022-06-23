/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.IllegalOrphanException;
import com.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Usuario;
import com.modelo.Detalleventa;
import com.modelo.Ordencompra;
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
public class OrdencompraJpaController extends Controller<Ordencompra> implements Serializable {

    public OrdencompraJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public OrdencompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordencompra ordencompra) {
        if (ordencompra.getDetalleventaCollection() == null) {
            ordencompra.setDetalleventaCollection(new ArrayList<Detalleventa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = ordencompra.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                ordencompra.setIdUsuario(idUsuario);
            }
            Collection<Detalleventa> attachedDetalleventaCollection = new ArrayList<Detalleventa>();
            for (Detalleventa detalleventaCollectionDetalleventaToAttach : ordencompra.getDetalleventaCollection()) {
                detalleventaCollectionDetalleventaToAttach = em.getReference(detalleventaCollectionDetalleventaToAttach.getClass(), detalleventaCollectionDetalleventaToAttach.getNumDetalle());
                attachedDetalleventaCollection.add(detalleventaCollectionDetalleventaToAttach);
            }
            ordencompra.setDetalleventaCollection(attachedDetalleventaCollection);
            em.persist(ordencompra);
            if (idUsuario != null) {
                idUsuario.getOrdencompraCollection().add(ordencompra);
                idUsuario = em.merge(idUsuario);
            }
            for (Detalleventa detalleventaCollectionDetalleventa : ordencompra.getDetalleventaCollection()) {
                Ordencompra oldNumeroFacturaOfDetalleventaCollectionDetalleventa = detalleventaCollectionDetalleventa.getNumeroFactura();
                detalleventaCollectionDetalleventa.setNumeroFactura(ordencompra);
                detalleventaCollectionDetalleventa = em.merge(detalleventaCollectionDetalleventa);
                if (oldNumeroFacturaOfDetalleventaCollectionDetalleventa != null) {
                    oldNumeroFacturaOfDetalleventaCollectionDetalleventa.getDetalleventaCollection().remove(detalleventaCollectionDetalleventa);
                    oldNumeroFacturaOfDetalleventaCollectionDetalleventa = em.merge(oldNumeroFacturaOfDetalleventaCollectionDetalleventa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordencompra ordencompra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordencompra persistentOrdencompra = em.find(Ordencompra.class, ordencompra.getNumeroFactura());
            Usuario idUsuarioOld = persistentOrdencompra.getIdUsuario();
            Usuario idUsuarioNew = ordencompra.getIdUsuario();
            Collection<Detalleventa> detalleventaCollectionOld = persistentOrdencompra.getDetalleventaCollection();
            Collection<Detalleventa> detalleventaCollectionNew = ordencompra.getDetalleventaCollection();
            List<String> illegalOrphanMessages = null;
            for (Detalleventa detalleventaCollectionOldDetalleventa : detalleventaCollectionOld) {
                if (!detalleventaCollectionNew.contains(detalleventaCollectionOldDetalleventa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detalleventa " + detalleventaCollectionOldDetalleventa + " since its numeroFactura field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                ordencompra.setIdUsuario(idUsuarioNew);
            }
            Collection<Detalleventa> attachedDetalleventaCollectionNew = new ArrayList<Detalleventa>();
            for (Detalleventa detalleventaCollectionNewDetalleventaToAttach : detalleventaCollectionNew) {
                detalleventaCollectionNewDetalleventaToAttach = em.getReference(detalleventaCollectionNewDetalleventaToAttach.getClass(), detalleventaCollectionNewDetalleventaToAttach.getNumDetalle());
                attachedDetalleventaCollectionNew.add(detalleventaCollectionNewDetalleventaToAttach);
            }
            detalleventaCollectionNew = attachedDetalleventaCollectionNew;
            ordencompra.setDetalleventaCollection(detalleventaCollectionNew);
            ordencompra = em.merge(ordencompra);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getOrdencompraCollection().remove(ordencompra);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getOrdencompraCollection().add(ordencompra);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            for (Detalleventa detalleventaCollectionNewDetalleventa : detalleventaCollectionNew) {
                if (!detalleventaCollectionOld.contains(detalleventaCollectionNewDetalleventa)) {
                    Ordencompra oldNumeroFacturaOfDetalleventaCollectionNewDetalleventa = detalleventaCollectionNewDetalleventa.getNumeroFactura();
                    detalleventaCollectionNewDetalleventa.setNumeroFactura(ordencompra);
                    detalleventaCollectionNewDetalleventa = em.merge(detalleventaCollectionNewDetalleventa);
                    if (oldNumeroFacturaOfDetalleventaCollectionNewDetalleventa != null && !oldNumeroFacturaOfDetalleventaCollectionNewDetalleventa.equals(ordencompra)) {
                        oldNumeroFacturaOfDetalleventaCollectionNewDetalleventa.getDetalleventaCollection().remove(detalleventaCollectionNewDetalleventa);
                        oldNumeroFacturaOfDetalleventaCollectionNewDetalleventa = em.merge(oldNumeroFacturaOfDetalleventaCollectionNewDetalleventa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordencompra.getNumeroFactura();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The ordencompra with id " + id + " no longer exists.");
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
            Ordencompra ordencompra;
            try {
                ordencompra = em.getReference(Ordencompra.class, id);
                ordencompra.getNumeroFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordencompra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Detalleventa> detalleventaCollectionOrphanCheck = ordencompra.getDetalleventaCollection();
            for (Detalleventa detalleventaCollectionOrphanCheckDetalleventa : detalleventaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ordencompra (" + ordencompra + ") cannot be destroyed since the Detalleventa " + detalleventaCollectionOrphanCheckDetalleventa + " in its detalleventaCollection field has a non-nullable numeroFactura field.");
            }
            if (illegalOrphanMessages != null) {
                try {
                    throw new IllegalOrphanException(illegalOrphanMessages);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(OrdencompraJpaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Usuario idUsuario = ordencompra.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getOrdencompraCollection().remove(ordencompra);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(ordencompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordencompra> findAllEntities() {
        return findOrdencompraEntities(true, -1, -1);
    }

    public List<Ordencompra> findOrdencompraEntities(int maxResults, int firstResult) {
        return findOrdencompraEntities(false, maxResults, firstResult);
    }

    private List<Ordencompra> findOrdencompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordencompra.class));
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

    public Ordencompra findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordencompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordencompra> rt = cq.from(Ordencompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
