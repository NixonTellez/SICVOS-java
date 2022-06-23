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
import com.modelo.Novedad;
import java.util.ArrayList;
import java.util.Collection;
import com.modelo.Ordencompra;
import com.modelo.Pqrs;
import com.modelo.Membresia;
import com.modelo.Usuario;
import com.modelo.Valoracion;
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
public class UsuarioJpaController extends Controller<Usuario> implements Serializable {

    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("SICVOSPU");
    }

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario){
        if (usuario.getNovedadCollection() == null) {
            usuario.setNovedadCollection(new ArrayList<Novedad>());
        }
        if (usuario.getOrdencompraCollection() == null) {
            usuario.setOrdencompraCollection(new ArrayList<Ordencompra>());
        }
        if (usuario.getPqrsCollection() == null) {
            usuario.setPqrsCollection(new ArrayList<Pqrs>());
        }
        if (usuario.getMembresiaCollection() == null) {
            usuario.setMembresiaCollection(new ArrayList<Membresia>());
        }
        if (usuario.getValoracionCollection() == null) {
            usuario.setValoracionCollection(new ArrayList<Valoracion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Novedad> attachedNovedadCollection = new ArrayList<Novedad>();
            for (Novedad novedadCollectionNovedadToAttach : usuario.getNovedadCollection()) {
                novedadCollectionNovedadToAttach = em.getReference(novedadCollectionNovedadToAttach.getClass(), novedadCollectionNovedadToAttach.getNumNovedad());
                attachedNovedadCollection.add(novedadCollectionNovedadToAttach);
            }
            usuario.setNovedadCollection(attachedNovedadCollection);
            Collection<Ordencompra> attachedOrdencompraCollection = new ArrayList<Ordencompra>();
            for (Ordencompra ordencompraCollectionOrdencompraToAttach : usuario.getOrdencompraCollection()) {
                ordencompraCollectionOrdencompraToAttach = em.getReference(ordencompraCollectionOrdencompraToAttach.getClass(), ordencompraCollectionOrdencompraToAttach.getNumeroFactura());
                attachedOrdencompraCollection.add(ordencompraCollectionOrdencompraToAttach);
            }
            usuario.setOrdencompraCollection(attachedOrdencompraCollection);
            Collection<Pqrs> attachedPqrsCollection = new ArrayList<Pqrs>();
            for (Pqrs pqrsCollectionPqrsToAttach : usuario.getPqrsCollection()) {
                pqrsCollectionPqrsToAttach = em.getReference(pqrsCollectionPqrsToAttach.getClass(), pqrsCollectionPqrsToAttach.getNumeroPQRS());
                attachedPqrsCollection.add(pqrsCollectionPqrsToAttach);
            }
            usuario.setPqrsCollection(attachedPqrsCollection);
            Collection<Membresia> attachedMembresiaCollection = new ArrayList<Membresia>();
            for (Membresia membresiaCollectionMembresiaToAttach : usuario.getMembresiaCollection()) {
                membresiaCollectionMembresiaToAttach = em.getReference(membresiaCollectionMembresiaToAttach.getClass(), membresiaCollectionMembresiaToAttach.getNumeroMembresia());
                attachedMembresiaCollection.add(membresiaCollectionMembresiaToAttach);
            }
            usuario.setMembresiaCollection(attachedMembresiaCollection);
            Collection<Valoracion> attachedValoracionCollection = new ArrayList<Valoracion>();
            for (Valoracion valoracionCollectionValoracionToAttach : usuario.getValoracionCollection()) {
                valoracionCollectionValoracionToAttach = em.getReference(valoracionCollectionValoracionToAttach.getClass(), valoracionCollectionValoracionToAttach.getNumeroValoracion());
                attachedValoracionCollection.add(valoracionCollectionValoracionToAttach);
            }
            usuario.setValoracionCollection(attachedValoracionCollection);
            em.persist(usuario);
            for (Novedad novedadCollectionNovedad : usuario.getNovedadCollection()) {
                Usuario oldIdUsuarioOfNovedadCollectionNovedad = novedadCollectionNovedad.getIdUsuario();
                novedadCollectionNovedad.setIdUsuario(usuario);
                novedadCollectionNovedad = em.merge(novedadCollectionNovedad);
                if (oldIdUsuarioOfNovedadCollectionNovedad != null) {
                    oldIdUsuarioOfNovedadCollectionNovedad.getNovedadCollection().remove(novedadCollectionNovedad);
                    oldIdUsuarioOfNovedadCollectionNovedad = em.merge(oldIdUsuarioOfNovedadCollectionNovedad);
                }
            }
            for (Ordencompra ordencompraCollectionOrdencompra : usuario.getOrdencompraCollection()) {
                Usuario oldIdUsuarioOfOrdencompraCollectionOrdencompra = ordencompraCollectionOrdencompra.getIdUsuario();
                ordencompraCollectionOrdencompra.setIdUsuario(usuario);
                ordencompraCollectionOrdencompra = em.merge(ordencompraCollectionOrdencompra);
                if (oldIdUsuarioOfOrdencompraCollectionOrdencompra != null) {
                    oldIdUsuarioOfOrdencompraCollectionOrdencompra.getOrdencompraCollection().remove(ordencompraCollectionOrdencompra);
                    oldIdUsuarioOfOrdencompraCollectionOrdencompra = em.merge(oldIdUsuarioOfOrdencompraCollectionOrdencompra);
                }
            }
            for (Pqrs pqrsCollectionPqrs : usuario.getPqrsCollection()) {
                Usuario oldIdUsuarioOfPqrsCollectionPqrs = pqrsCollectionPqrs.getIdUsuario();
                pqrsCollectionPqrs.setIdUsuario(usuario);
                pqrsCollectionPqrs = em.merge(pqrsCollectionPqrs);
                if (oldIdUsuarioOfPqrsCollectionPqrs != null) {
                    oldIdUsuarioOfPqrsCollectionPqrs.getPqrsCollection().remove(pqrsCollectionPqrs);
                    oldIdUsuarioOfPqrsCollectionPqrs = em.merge(oldIdUsuarioOfPqrsCollectionPqrs);
                }
            }
            for (Membresia membresiaCollectionMembresia : usuario.getMembresiaCollection()) {
                Usuario oldIdUsuarioOfMembresiaCollectionMembresia = membresiaCollectionMembresia.getIdUsuario();
                membresiaCollectionMembresia.setIdUsuario(usuario);
                membresiaCollectionMembresia = em.merge(membresiaCollectionMembresia);
                if (oldIdUsuarioOfMembresiaCollectionMembresia != null) {
                    oldIdUsuarioOfMembresiaCollectionMembresia.getMembresiaCollection().remove(membresiaCollectionMembresia);
                    oldIdUsuarioOfMembresiaCollectionMembresia = em.merge(oldIdUsuarioOfMembresiaCollectionMembresia);
                }
            }
            for (Valoracion valoracionCollectionValoracion : usuario.getValoracionCollection()) {
                Usuario oldIdUsuarioOfValoracionCollectionValoracion = valoracionCollectionValoracion.getIdUsuario();
                valoracionCollectionValoracion.setIdUsuario(usuario);
                valoracionCollectionValoracion = em.merge(valoracionCollectionValoracion);
                if (oldIdUsuarioOfValoracionCollectionValoracion != null) {
                    oldIdUsuarioOfValoracionCollectionValoracion.getValoracionCollection().remove(valoracionCollectionValoracion);
                    oldIdUsuarioOfValoracionCollectionValoracion = em.merge(oldIdUsuarioOfValoracionCollectionValoracion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntity(usuario.getIdUsuario()) != null) {
                try {
                    throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
                } catch (PreexistingEntityException ex1) {
                    Logger.getLogger(UsuarioJpaController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            Collection<Novedad> novedadCollectionOld = persistentUsuario.getNovedadCollection();
            Collection<Novedad> novedadCollectionNew = usuario.getNovedadCollection();
            Collection<Ordencompra> ordencompraCollectionOld = persistentUsuario.getOrdencompraCollection();
            Collection<Ordencompra> ordencompraCollectionNew = usuario.getOrdencompraCollection();
            Collection<Pqrs> pqrsCollectionOld = persistentUsuario.getPqrsCollection();
            Collection<Pqrs> pqrsCollectionNew = usuario.getPqrsCollection();
            Collection<Membresia> membresiaCollectionOld = persistentUsuario.getMembresiaCollection();
            Collection<Membresia> membresiaCollectionNew = usuario.getMembresiaCollection();
            Collection<Valoracion> valoracionCollectionOld = persistentUsuario.getValoracionCollection();
            Collection<Valoracion> valoracionCollectionNew = usuario.getValoracionCollection();
            List<String> illegalOrphanMessages = null;
            for (Novedad novedadCollectionOldNovedad : novedadCollectionOld) {
                if (!novedadCollectionNew.contains(novedadCollectionOldNovedad)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Novedad " + novedadCollectionOldNovedad + " since its idUsuario field is not nullable.");
                }
            }
            for (Ordencompra ordencompraCollectionOldOrdencompra : ordencompraCollectionOld) {
                if (!ordencompraCollectionNew.contains(ordencompraCollectionOldOrdencompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordencompra " + ordencompraCollectionOldOrdencompra + " since its idUsuario field is not nullable.");
                }
            }
            for (Pqrs pqrsCollectionOldPqrs : pqrsCollectionOld) {
                if (!pqrsCollectionNew.contains(pqrsCollectionOldPqrs)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pqrs " + pqrsCollectionOldPqrs + " since its idUsuario field is not nullable.");
                }
            }
            for (Membresia membresiaCollectionOldMembresia : membresiaCollectionOld) {
                if (!membresiaCollectionNew.contains(membresiaCollectionOldMembresia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Membresia " + membresiaCollectionOldMembresia + " since its idUsuario field is not nullable.");
                }
            }
            for (Valoracion valoracionCollectionOldValoracion : valoracionCollectionOld) {
                if (!valoracionCollectionNew.contains(valoracionCollectionOldValoracion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Valoracion " + valoracionCollectionOldValoracion + " since its idUsuario field is not nullable.");
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
            usuario.setNovedadCollection(novedadCollectionNew);
            Collection<Ordencompra> attachedOrdencompraCollectionNew = new ArrayList<Ordencompra>();
            for (Ordencompra ordencompraCollectionNewOrdencompraToAttach : ordencompraCollectionNew) {
                ordencompraCollectionNewOrdencompraToAttach = em.getReference(ordencompraCollectionNewOrdencompraToAttach.getClass(), ordencompraCollectionNewOrdencompraToAttach.getNumeroFactura());
                attachedOrdencompraCollectionNew.add(ordencompraCollectionNewOrdencompraToAttach);
            }
            ordencompraCollectionNew = attachedOrdencompraCollectionNew;
            usuario.setOrdencompraCollection(ordencompraCollectionNew);
            Collection<Pqrs> attachedPqrsCollectionNew = new ArrayList<Pqrs>();
            for (Pqrs pqrsCollectionNewPqrsToAttach : pqrsCollectionNew) {
                pqrsCollectionNewPqrsToAttach = em.getReference(pqrsCollectionNewPqrsToAttach.getClass(), pqrsCollectionNewPqrsToAttach.getNumeroPQRS());
                attachedPqrsCollectionNew.add(pqrsCollectionNewPqrsToAttach);
            }
            pqrsCollectionNew = attachedPqrsCollectionNew;
            usuario.setPqrsCollection(pqrsCollectionNew);
            Collection<Membresia> attachedMembresiaCollectionNew = new ArrayList<Membresia>();
            for (Membresia membresiaCollectionNewMembresiaToAttach : membresiaCollectionNew) {
                membresiaCollectionNewMembresiaToAttach = em.getReference(membresiaCollectionNewMembresiaToAttach.getClass(), membresiaCollectionNewMembresiaToAttach.getNumeroMembresia());
                attachedMembresiaCollectionNew.add(membresiaCollectionNewMembresiaToAttach);
            }
            membresiaCollectionNew = attachedMembresiaCollectionNew;
            usuario.setMembresiaCollection(membresiaCollectionNew);
            Collection<Valoracion> attachedValoracionCollectionNew = new ArrayList<Valoracion>();
            for (Valoracion valoracionCollectionNewValoracionToAttach : valoracionCollectionNew) {
                valoracionCollectionNewValoracionToAttach = em.getReference(valoracionCollectionNewValoracionToAttach.getClass(), valoracionCollectionNewValoracionToAttach.getNumeroValoracion());
                attachedValoracionCollectionNew.add(valoracionCollectionNewValoracionToAttach);
            }
            valoracionCollectionNew = attachedValoracionCollectionNew;
            usuario.setValoracionCollection(valoracionCollectionNew);
            usuario = em.merge(usuario);
            for (Novedad novedadCollectionNewNovedad : novedadCollectionNew) {
                if (!novedadCollectionOld.contains(novedadCollectionNewNovedad)) {
                    Usuario oldIdUsuarioOfNovedadCollectionNewNovedad = novedadCollectionNewNovedad.getIdUsuario();
                    novedadCollectionNewNovedad.setIdUsuario(usuario);
                    novedadCollectionNewNovedad = em.merge(novedadCollectionNewNovedad);
                    if (oldIdUsuarioOfNovedadCollectionNewNovedad != null && !oldIdUsuarioOfNovedadCollectionNewNovedad.equals(usuario)) {
                        oldIdUsuarioOfNovedadCollectionNewNovedad.getNovedadCollection().remove(novedadCollectionNewNovedad);
                        oldIdUsuarioOfNovedadCollectionNewNovedad = em.merge(oldIdUsuarioOfNovedadCollectionNewNovedad);
                    }
                }
            }
            for (Ordencompra ordencompraCollectionNewOrdencompra : ordencompraCollectionNew) {
                if (!ordencompraCollectionOld.contains(ordencompraCollectionNewOrdencompra)) {
                    Usuario oldIdUsuarioOfOrdencompraCollectionNewOrdencompra = ordencompraCollectionNewOrdencompra.getIdUsuario();
                    ordencompraCollectionNewOrdencompra.setIdUsuario(usuario);
                    ordencompraCollectionNewOrdencompra = em.merge(ordencompraCollectionNewOrdencompra);
                    if (oldIdUsuarioOfOrdencompraCollectionNewOrdencompra != null && !oldIdUsuarioOfOrdencompraCollectionNewOrdencompra.equals(usuario)) {
                        oldIdUsuarioOfOrdencompraCollectionNewOrdencompra.getOrdencompraCollection().remove(ordencompraCollectionNewOrdencompra);
                        oldIdUsuarioOfOrdencompraCollectionNewOrdencompra = em.merge(oldIdUsuarioOfOrdencompraCollectionNewOrdencompra);
                    }
                }
            }
            for (Pqrs pqrsCollectionNewPqrs : pqrsCollectionNew) {
                if (!pqrsCollectionOld.contains(pqrsCollectionNewPqrs)) {
                    Usuario oldIdUsuarioOfPqrsCollectionNewPqrs = pqrsCollectionNewPqrs.getIdUsuario();
                    pqrsCollectionNewPqrs.setIdUsuario(usuario);
                    pqrsCollectionNewPqrs = em.merge(pqrsCollectionNewPqrs);
                    if (oldIdUsuarioOfPqrsCollectionNewPqrs != null && !oldIdUsuarioOfPqrsCollectionNewPqrs.equals(usuario)) {
                        oldIdUsuarioOfPqrsCollectionNewPqrs.getPqrsCollection().remove(pqrsCollectionNewPqrs);
                        oldIdUsuarioOfPqrsCollectionNewPqrs = em.merge(oldIdUsuarioOfPqrsCollectionNewPqrs);
                    }
                }
            }
            for (Membresia membresiaCollectionNewMembresia : membresiaCollectionNew) {
                if (!membresiaCollectionOld.contains(membresiaCollectionNewMembresia)) {
                    Usuario oldIdUsuarioOfMembresiaCollectionNewMembresia = membresiaCollectionNewMembresia.getIdUsuario();
                    membresiaCollectionNewMembresia.setIdUsuario(usuario);
                    membresiaCollectionNewMembresia = em.merge(membresiaCollectionNewMembresia);
                    if (oldIdUsuarioOfMembresiaCollectionNewMembresia != null && !oldIdUsuarioOfMembresiaCollectionNewMembresia.equals(usuario)) {
                        oldIdUsuarioOfMembresiaCollectionNewMembresia.getMembresiaCollection().remove(membresiaCollectionNewMembresia);
                        oldIdUsuarioOfMembresiaCollectionNewMembresia = em.merge(oldIdUsuarioOfMembresiaCollectionNewMembresia);
                    }
                }
            }
            for (Valoracion valoracionCollectionNewValoracion : valoracionCollectionNew) {
                if (!valoracionCollectionOld.contains(valoracionCollectionNewValoracion)) {
                    Usuario oldIdUsuarioOfValoracionCollectionNewValoracion = valoracionCollectionNewValoracion.getIdUsuario();
                    valoracionCollectionNewValoracion.setIdUsuario(usuario);
                    valoracionCollectionNewValoracion = em.merge(valoracionCollectionNewValoracion);
                    if (oldIdUsuarioOfValoracionCollectionNewValoracion != null && !oldIdUsuarioOfValoracionCollectionNewValoracion.equals(usuario)) {
                        oldIdUsuarioOfValoracionCollectionNewValoracion.getValoracionCollection().remove(valoracionCollectionNewValoracion);
                        oldIdUsuarioOfValoracionCollectionNewValoracion = em.merge(oldIdUsuarioOfValoracionCollectionNewValoracion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdUsuario();
                if (findEntity(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario = null;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                try {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(UsuarioJpaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            List<String> illegalOrphanMessages = null;
            Collection<Novedad> novedadCollectionOrphanCheck = usuario.getNovedadCollection();
            for (Novedad novedadCollectionOrphanCheckNovedad : novedadCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Novedad " + novedadCollectionOrphanCheckNovedad + " in its novedadCollection field has a non-nullable idUsuario field.");
            }
            Collection<Ordencompra> ordencompraCollectionOrphanCheck = usuario.getOrdencompraCollection();
            for (Ordencompra ordencompraCollectionOrphanCheckOrdencompra : ordencompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Ordencompra " + ordencompraCollectionOrphanCheckOrdencompra + " in its ordencompraCollection field has a non-nullable idUsuario field.");
            }
            Collection<Pqrs> pqrsCollectionOrphanCheck = usuario.getPqrsCollection();
            for (Pqrs pqrsCollectionOrphanCheckPqrs : pqrsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Pqrs " + pqrsCollectionOrphanCheckPqrs + " in its pqrsCollection field has a non-nullable idUsuario field.");
            }
            Collection<Membresia> membresiaCollectionOrphanCheck = usuario.getMembresiaCollection();
            for (Membresia membresiaCollectionOrphanCheckMembresia : membresiaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Membresia " + membresiaCollectionOrphanCheckMembresia + " in its membresiaCollection field has a non-nullable idUsuario field.");
            }
            Collection<Valoracion> valoracionCollectionOrphanCheck = usuario.getValoracionCollection();
            for (Valoracion valoracionCollectionOrphanCheckValoracion : valoracionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Valoracion " + valoracionCollectionOrphanCheckValoracion + " in its valoracionCollection field has a non-nullable idUsuario field.");
            }
            if (illegalOrphanMessages != null) {
                try {
                    throw new IllegalOrphanException(illegalOrphanMessages);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(UsuarioJpaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findAllEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Usuario validarUsuario(int idUsuario, String contraseña){
        Usuario user;
        EntityManager em = emf.createEntityManager();
        String sql="SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario AND u.contraseña = :contraseña";
        Query query = em.createQuery(sql);
        
        query.setParameter("idUsuario", idUsuario);
        query.setParameter("contraseña", contraseña);
        user= (Usuario) query.getSingleResult();
        
        return user;
    }
    
}
