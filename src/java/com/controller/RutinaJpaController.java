/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Membresia;
import com.modelo.Rutina;
import com.controller.exceptions.NonexistentEntityException;
import com.controller.exceptions.PreexistingEntityException;
import com.modelo.Usuario;
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
public class RutinaJpaController extends Controller<Rutina> implements Serializable {
    
    public RutinaJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }
    
    public RutinaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rutina rutina){
        if (rutina.getMembresiaCollection() == null) {
            rutina.setMembresiaCollection(new ArrayList<Membresia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Membresia> attachedMembresiaCollection = new ArrayList<Membresia>();
            for (Membresia membresiaCollectionMembresiaToAttach : rutina.getMembresiaCollection()) {
                membresiaCollectionMembresiaToAttach = em.getReference(membresiaCollectionMembresiaToAttach.getClass(), membresiaCollectionMembresiaToAttach.getNumeroMembresia());
                attachedMembresiaCollection.add(membresiaCollectionMembresiaToAttach);
            }
            rutina.setMembresiaCollection(attachedMembresiaCollection);
            em.persist(rutina);
            for (Membresia membresiaCollectionMembresia : rutina.getMembresiaCollection()) {
                Rutina oldDiasRestantesOfMembresiaCollectionMembresia = membresiaCollectionMembresia.getDiasRestantes();
                membresiaCollectionMembresia.setDiasRestantes(rutina);
                membresiaCollectionMembresia = em.merge(membresiaCollectionMembresia);
                if (oldDiasRestantesOfMembresiaCollectionMembresia != null) {
                    oldDiasRestantesOfMembresiaCollectionMembresia.getMembresiaCollection().remove(membresiaCollectionMembresia);
                    oldDiasRestantesOfMembresiaCollectionMembresia = em.merge(oldDiasRestantesOfMembresiaCollectionMembresia);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntity(rutina.getDia()) != null) {
                try {
                    throw new PreexistingEntityException("Rutina " + rutina + " already exists.", ex);
                } catch (PreexistingEntityException ex1) {
                    Logger.getLogger(RutinaJpaController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rutina rutina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rutina persistentRutina = em.find(Rutina.class, rutina.getDia());
            Collection<Membresia> membresiaCollectionOld = persistentRutina.getMembresiaCollection();
            Collection<Membresia> membresiaCollectionNew = rutina.getMembresiaCollection();
            Collection<Membresia> attachedMembresiaCollectionNew = new ArrayList<Membresia>();
            for (Membresia membresiaCollectionNewMembresiaToAttach : membresiaCollectionNew) {
                membresiaCollectionNewMembresiaToAttach = em.getReference(membresiaCollectionNewMembresiaToAttach.getClass(), membresiaCollectionNewMembresiaToAttach.getNumeroMembresia());
                attachedMembresiaCollectionNew.add(membresiaCollectionNewMembresiaToAttach);
            }
            membresiaCollectionNew = attachedMembresiaCollectionNew;
            rutina.setMembresiaCollection(membresiaCollectionNew);
            rutina = em.merge(rutina);
            for (Membresia membresiaCollectionOldMembresia : membresiaCollectionOld) {
                if (!membresiaCollectionNew.contains(membresiaCollectionOldMembresia)) {
                    membresiaCollectionOldMembresia.setDiasRestantes(null);
                    membresiaCollectionOldMembresia = em.merge(membresiaCollectionOldMembresia);
                }
            }
            for (Membresia membresiaCollectionNewMembresia : membresiaCollectionNew) {
                if (!membresiaCollectionOld.contains(membresiaCollectionNewMembresia)) {
                    Rutina oldDiasRestantesOfMembresiaCollectionNewMembresia = membresiaCollectionNewMembresia.getDiasRestantes();
                    membresiaCollectionNewMembresia.setDiasRestantes(rutina);
                    membresiaCollectionNewMembresia = em.merge(membresiaCollectionNewMembresia);
                    if (oldDiasRestantesOfMembresiaCollectionNewMembresia != null && !oldDiasRestantesOfMembresiaCollectionNewMembresia.equals(rutina)) {
                        oldDiasRestantesOfMembresiaCollectionNewMembresia.getMembresiaCollection().remove(membresiaCollectionNewMembresia);
                        oldDiasRestantesOfMembresiaCollectionNewMembresia = em.merge(oldDiasRestantesOfMembresiaCollectionNewMembresia);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rutina.getDia();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The rutina with id " + id + " no longer exists.");
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
            Rutina rutina;
            try {
                rutina = em.getReference(Rutina.class, id);
                rutina.getDia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rutina with id " + id + " no longer exists.", enfe);
            }
            Collection<Membresia> membresiaCollection = rutina.getMembresiaCollection();
            for (Membresia membresiaCollectionMembresia : membresiaCollection) {
                membresiaCollectionMembresia.setDiasRestantes(null);
                membresiaCollectionMembresia = em.merge(membresiaCollectionMembresia);
            }
            em.remove(rutina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rutina> findAllEntities() {
        return findRutinaEntities(true, -1, -1);
    }

    public List<Rutina> findRutinaEntities(int maxResults, int firstResult) {
        return findRutinaEntities(false, maxResults, firstResult);
    }

    private List<Rutina> findRutinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rutina.class));
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

    public Rutina findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rutina.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rutina> rt = cq.from(Rutina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Rutina validarRutina(Usuario idUsuario){
        Rutina rutine;
        EntityManager em = emf.createEntityManager();
        String sql="SELECT r FROM Rutina r WHERE r.dia IN (SELECT diasRestantes FROM Membresia m WHERE m.idUsuario=:idUsuario); ";
        Query query = em.createQuery(sql);
        
        query.setParameter("idUsuario", idUsuario);
        rutine= (Rutina) query.getSingleResult();
        
        em.close();
        return rutine;
    }
    
}
