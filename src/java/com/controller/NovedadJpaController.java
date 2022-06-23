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
import com.modelo.Maquina;
import com.modelo.Novedad;
import com.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 10 Spring Creators
 */
public class NovedadJpaController extends Controller<Novedad> implements Serializable {

    public NovedadJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public NovedadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Novedad novedad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquina idMaquina = novedad.getIdMaquina();
            if (idMaquina != null) {
                novedad.setIdMaquina(idMaquina);
            }
            Usuario idUsuario = novedad.getIdUsuario();
            if (idUsuario != null) {
                novedad.setIdUsuario(idUsuario);
            }
            em.persist(novedad);
            if (idMaquina != null) {
                idMaquina.getNovedadCollection().add(novedad);
                idMaquina = em.merge(idMaquina);
            }
            if (idUsuario != null) {
                idUsuario.getNovedadCollection().add(novedad);
                idUsuario = em.merge(idUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Novedad novedad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Novedad persistentNovedad = em.find(Novedad.class, novedad.getNumNovedad());
            Maquina idMaquinaOld = persistentNovedad.getIdMaquina();
            Maquina idMaquinaNew = novedad.getIdMaquina();
            Usuario idUsuarioOld = persistentNovedad.getIdUsuario();
            Usuario idUsuarioNew = novedad.getIdUsuario();
            if (idMaquinaNew != null) {
                idMaquinaNew = em.getReference(idMaquinaNew.getClass(), idMaquinaNew.getIdMaquina());
                novedad.setIdMaquina(idMaquinaNew);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                novedad.setIdUsuario(idUsuarioNew);
            }
            novedad = em.merge(novedad);
            if (idMaquinaOld != null && !idMaquinaOld.equals(idMaquinaNew)) {
                idMaquinaOld.getNovedadCollection().remove(novedad);
                idMaquinaOld = em.merge(idMaquinaOld);
            }
            if (idMaquinaNew != null && !idMaquinaNew.equals(idMaquinaOld)) {
                idMaquinaNew.getNovedadCollection().add(novedad);
                idMaquinaNew = em.merge(idMaquinaNew);
            }
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getNovedadCollection().remove(novedad);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getNovedadCollection().add(novedad);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = novedad.getNumNovedad();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The novedad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Novedad novedad;
            try {
                novedad = em.getReference(Novedad.class, id);
                novedad.getNumNovedad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The novedad with id " + id + " no longer exists.", enfe);
            }
            Maquina idMaquina = novedad.getIdMaquina();
            if (idMaquina != null) {
                idMaquina.getNovedadCollection().remove(novedad);
                idMaquina = em.merge(idMaquina);
            }
            Usuario idUsuario = novedad.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getNovedadCollection().remove(novedad);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(novedad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Novedad> findAllEntities() {
        return findNovedadEntities(true, -1, -1);
    }

    public List<Novedad> findNovedadEntities(int maxResults, int firstResult) {
        return findNovedadEntities(false, maxResults, firstResult);
    }

    private List<Novedad> findNovedadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Novedad.class));
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

    public Novedad findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Novedad.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Novedad> rt = cq.from(Novedad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
