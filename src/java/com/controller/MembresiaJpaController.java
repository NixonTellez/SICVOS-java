/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.controller.exceptions.NonexistentEntityException;
import com.modelo.Membresia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Usuario;
import com.modelo.Rutina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 10 Spring Creators
 */
public class MembresiaJpaController extends Controller<Membresia> implements Serializable {

    public MembresiaJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public MembresiaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Membresia membresia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = membresia.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                membresia.setIdUsuario(idUsuario);
            }
            Rutina diasRestantes = membresia.getDiasRestantes();
            if (diasRestantes != null) {
                diasRestantes = em.getReference(diasRestantes.getClass(), diasRestantes.getDia());
                membresia.setDiasRestantes(diasRestantes);
            }
            em.persist(membresia);
            if (idUsuario != null) {
                idUsuario.getMembresiaCollection().add(membresia);
                idUsuario = em.merge(idUsuario);
            }
            if (diasRestantes != null) {
                diasRestantes.getMembresiaCollection().add(membresia);
                diasRestantes = em.merge(diasRestantes);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Membresia membresia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Membresia persistentMembresia = em.find(Membresia.class, membresia.getNumeroMembresia());
            Usuario idUsuarioOld = persistentMembresia.getIdUsuario();
            Usuario idUsuarioNew = membresia.getIdUsuario();
            Rutina diasRestantesOld = persistentMembresia.getDiasRestantes();
            Rutina diasRestantesNew = membresia.getDiasRestantes();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                membresia.setIdUsuario(idUsuarioNew);
            }
            if (diasRestantesNew != null) {
                diasRestantesNew = em.getReference(diasRestantesNew.getClass(), diasRestantesNew.getDia());
                membresia.setDiasRestantes(diasRestantesNew);
            }
            membresia = em.merge(membresia);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getMembresiaCollection().remove(membresia);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getMembresiaCollection().add(membresia);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (diasRestantesOld != null && !diasRestantesOld.equals(diasRestantesNew)) {
                diasRestantesOld.getMembresiaCollection().remove(membresia);
                diasRestantesOld = em.merge(diasRestantesOld);
            }
            if (diasRestantesNew != null && !diasRestantesNew.equals(diasRestantesOld)) {
                diasRestantesNew.getMembresiaCollection().add(membresia);
                diasRestantesNew = em.merge(diasRestantesNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = membresia.getNumeroMembresia();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The membresia with id " + id + " no longer exists.");
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
            Membresia membresia;
            try {
                membresia = em.getReference(Membresia.class, id);
                membresia.getNumeroMembresia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The membresia with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = membresia.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getMembresiaCollection().remove(membresia);
                idUsuario = em.merge(idUsuario);
            }
            Rutina diasRestantes = membresia.getDiasRestantes();
            if (diasRestantes != null) {
                diasRestantes.getMembresiaCollection().remove(membresia);
                diasRestantes = em.merge(diasRestantes);
            }
            em.remove(membresia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Membresia> findAllEntities() {
        return findMembresiaEntities(true, -1, -1);
    }

    public List<Membresia> findMembresiaEntities(int maxResults, int firstResult) {
        return findMembresiaEntities(false, maxResults, firstResult);
    }

    private List<Membresia> findMembresiaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Membresia.class));
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

    public Membresia findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Membresia.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Membresia> rt = cq.from(Membresia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Membresia validarMembresia(Usuario idUsuario) throws NullPointerException{
        Membresia user=null;
        EntityManager em = emf.createEntityManager();
        String sql="SELECT m FROM Membresia m WHERE m.idUsuario = :idUsuario";
        Query query = em.createQuery(sql);
        
        query.setParameter("idUsuario", idUsuario);
        try{
            user= (Membresia) query.getSingleResult();
        }catch(Exception e){
            
        }finally{
            em.close();
        }
        
        return user;
    }
    
}
