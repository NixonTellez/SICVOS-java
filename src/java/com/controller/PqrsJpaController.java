/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.NonexistentEntityException;
import com.modelo.Pqrs;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 10 Spring Creators
 */
public class PqrsJpaController extends Controller<Pqrs> implements Serializable {

    public PqrsJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public PqrsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pqrs pqrs) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = pqrs.getIdUsuario();
            if (idUsuario != null) {
                pqrs.setIdUsuario(idUsuario);
            }
            em.persist(pqrs);
            if (idUsuario != null) {
                idUsuario.getPqrsCollection().add(pqrs);
                idUsuario = em.merge(idUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pqrs pqrs) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pqrs persistentPqrs = em.find(Pqrs.class, pqrs.getNumeroPQRS());
            Usuario idUsuarioOld = persistentPqrs.getIdUsuario();
            Usuario idUsuarioNew = pqrs.getIdUsuario();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                pqrs.setIdUsuario(idUsuarioNew);
            }
            pqrs = em.merge(pqrs);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getPqrsCollection().remove(pqrs);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getPqrsCollection().add(pqrs);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pqrs.getNumeroPQRS();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The pqrs with id " + id + " no longer exists.");
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
            Pqrs pqrs;
            try {
                pqrs = em.getReference(Pqrs.class, id);
                pqrs.getNumeroPQRS();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pqrs with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = pqrs.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getPqrsCollection().remove(pqrs);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(pqrs);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pqrs> findAllEntities() {
        return findPqrsEntities(true, -1, -1);
    }

    public List<Pqrs> findPqrsEntities(int maxResults, int firstResult) {
        return findPqrsEntities(false, maxResults, firstResult);
    }

    private List<Pqrs> findPqrsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pqrs.class));
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

    public Pqrs findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pqrs.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pqrs> rt = cq.from(Pqrs.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
