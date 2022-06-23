/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Usuario;
import com.modelo.Valoracion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 10 Spring Creators
 */
public class ValoracionJpaController extends Controller<Valoracion> implements Serializable {

    public ValoracionJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public ValoracionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Valoracion valoracion) {
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = valoracion.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                valoracion.setIdUsuario(idUsuario);
            }
            em.persist(valoracion);
            if (idUsuario != null) {
                idUsuario.getValoracionCollection().add(valoracion);
                idUsuario = em.merge(idUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Valoracion valoracion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Valoracion persistentValoracion = em.find(Valoracion.class, valoracion.getNumeroValoracion());
            Usuario idUsuarioOld = persistentValoracion.getIdUsuario();
            Usuario idUsuarioNew = valoracion.getIdUsuario();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                valoracion.setIdUsuario(idUsuarioNew);
            }
            valoracion = em.merge(valoracion);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getValoracionCollection().remove(valoracion);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getValoracionCollection().add(valoracion);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = valoracion.getNumeroValoracion();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The valoracion with id " + id + " no longer exists.");
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
            Valoracion valoracion;
            try {
                valoracion = em.getReference(Valoracion.class, id);
                valoracion.getNumeroValoracion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The valoracion with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = valoracion.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getValoracionCollection().remove(valoracion);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(valoracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Valoracion> findAllEntities() {
        return findValoracionEntities(true, -1, -1);
    }

    public List<Valoracion> findValoracionEntities(int maxResults, int firstResult) {
        return findValoracionEntities(false, maxResults, firstResult);
    }

    private List<Valoracion> findValoracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Valoracion.class));
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

    public Valoracion findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Valoracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Valoracion> rt = cq.from(Valoracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Valoracion> userValoraciones(Usuario idUsuario){
        EntityManager em = emf.createEntityManager();
        String sql="SELECT v FROM Valoracion v WHERE v.idUsuario = :idUsuario";
        Query query = em.createQuery(sql);
        
        query.setParameter("idUsuario", idUsuario);
        
        return (List<Valoracion>)query.getResultList();
    }

}
