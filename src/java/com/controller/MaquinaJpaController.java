/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.IllegalOrphanException;
import com.controller.exceptions.NonexistentEntityException;
import com.controller.exceptions.PreexistingEntityException;
import com.modelo.Maquina;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Novedad;
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
public class MaquinaJpaController extends Controller<Maquina> implements Serializable {

    public MaquinaJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public MaquinaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maquina maquina){
        if (maquina.getNovedadCollection() == null) {
            maquina.setNovedadCollection(new ArrayList<Novedad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Novedad> attachedNovedadCollection = new ArrayList<Novedad>();
            for (Novedad novedadCollectionNovedadToAttach : maquina.getNovedadCollection()) {
                novedadCollectionNovedadToAttach = em.getReference(novedadCollectionNovedadToAttach.getClass(), novedadCollectionNovedadToAttach.getNumNovedad());
                attachedNovedadCollection.add(novedadCollectionNovedadToAttach);
            }
            maquina.setNovedadCollection(attachedNovedadCollection);
            em.persist(maquina);
            for (Novedad novedadCollectionNovedad : maquina.getNovedadCollection()) {
                Maquina oldIdMaquinaOfNovedadCollectionNovedad = novedadCollectionNovedad.getIdMaquina();
                novedadCollectionNovedad.setIdMaquina(maquina);
                novedadCollectionNovedad = em.merge(novedadCollectionNovedad);
                if (oldIdMaquinaOfNovedadCollectionNovedad != null) {
                    oldIdMaquinaOfNovedadCollectionNovedad.getNovedadCollection().remove(novedadCollectionNovedad);
                    oldIdMaquinaOfNovedadCollectionNovedad = em.merge(oldIdMaquinaOfNovedadCollectionNovedad);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntity(maquina.getIdMaquina()) != null) {
                try {
                    throw new PreexistingEntityException("Maquina " + maquina + " already exists.", ex);
                } catch (PreexistingEntityException ex1) {
                    Logger.getLogger(MaquinaJpaController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maquina maquina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquina persistentMaquina = em.find(Maquina.class, maquina.getIdMaquina());
            Collection<Novedad> novedadCollectionOld = persistentMaquina.getNovedadCollection();
            Collection<Novedad> novedadCollectionNew = maquina.getNovedadCollection();
            List<String> illegalOrphanMessages = null;
            for (Novedad novedadCollectionOldNovedad : novedadCollectionOld) {
                if (!novedadCollectionNew.contains(novedadCollectionOldNovedad)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Novedad " + novedadCollectionOldNovedad + " since its idMaquina field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Novedad> attachedNovedadCollectionNew = new ArrayList<Novedad>();
            for (Novedad novedadCollectionNewNovedadToAttach : novedadCollectionNew) {
                novedadCollectionNewNovedadToAttach = em.getReference(novedadCollectionNewNovedadToAttach.getClass(), novedadCollectionNewNovedadToAttach.getNumNovedad());
                attachedNovedadCollectionNew.add(novedadCollectionNewNovedadToAttach);
            }
            novedadCollectionNew = attachedNovedadCollectionNew;
            maquina.setNovedadCollection(novedadCollectionNew);
            maquina = em.merge(maquina);
            for (Novedad novedadCollectionNewNovedad : novedadCollectionNew) {
                if (!novedadCollectionOld.contains(novedadCollectionNewNovedad)) {
                    Maquina oldIdMaquinaOfNovedadCollectionNewNovedad = novedadCollectionNewNovedad.getIdMaquina();
                    novedadCollectionNewNovedad.setIdMaquina(maquina);
                    novedadCollectionNewNovedad = em.merge(novedadCollectionNewNovedad);
                    if (oldIdMaquinaOfNovedadCollectionNewNovedad != null && !oldIdMaquinaOfNovedadCollectionNewNovedad.equals(maquina)) {
                        oldIdMaquinaOfNovedadCollectionNewNovedad.getNovedadCollection().remove(novedadCollectionNewNovedad);
                        oldIdMaquinaOfNovedadCollectionNewNovedad = em.merge(oldIdMaquinaOfNovedadCollectionNewNovedad);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = maquina.getIdMaquina();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The maquina with id " + id + " no longer exists.");
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
            Maquina maquina;
            try {
                maquina = em.getReference(Maquina.class, id);
                maquina.getIdMaquina();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maquina with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            em.remove(maquina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maquina> findAllEntities() {
        return findMaquinaEntities(true, -1, -1);
    }

    public List<Maquina> findMaquinaEntities(int maxResults, int firstResult) {
        return findMaquinaEntities(false, maxResults, firstResult);
    }

    private List<Maquina> findMaquinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maquina.class));
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

    public Maquina findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maquina.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maquina> rt = cq.from(Maquina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
}
